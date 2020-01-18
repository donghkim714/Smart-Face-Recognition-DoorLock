# face_recog.py
from operator import eq
import face_recognition
import cv2
from FaceDetect import camera
import os
import numpy as np
import datetime
import pymysql
class FaceRecog():
    permission = 0
    UnAuthenicated = 0
    def __init__(self):

        # Using OpenCV to capture from device 0. If you have trouble capturing
        # from a webcam, comment the line below out and use a video file
        # instead.
        self.camera = camera.VideoCamera()

        self.known_face_encodings = []
        self.known_face_names = []
        self.test_face_encodings = []

        dirname = 'D:\Document\Phyton\Recognition\knowns'
        files = os.listdir(dirname)
        for filename in files:
            name, ext = os.path.splitext(filename)
            if ext == '.jpg':
                self.known_face_names.append(name)
                pathname = os.path.join(dirname, filename)

                img = face_recognition.load_image_file(pathname)
                face_encoding = face_recognition.face_encodings(img)[0]
                self.known_face_encodings.append(face_encoding)

        direc = 'C:\\Users\\GZ\\share'
        files = os.listdir(direc)
        for filename in files:
            name, ext = os.path.splitext(filename)
            if ext == '.jpg':
                pathname = os.path.join(direc, filename)
                img2 = face_recognition.load_image_file(pathname)
               # face_encoding2 = face_recognition.face_encodings(img2)[0]
               # self.test_face_encodings.append(face_encoding2)

        # Load sample pictures and learn how to recognize it.

        # Initialize some variables
        self.face_locations = []
        self.face_encodings = []
        self.face_names = []
        self.process_this_frame = True


    def get_frame(self):
        # Grab a single frame of video
        #frame = face_recognition.load_image_file('./testFile/test.jpg')
        #frame = Image.open('./testFile/test.jpg')
        frame = cv2.imread('C:\\Users\\GZ\\share\\detect123.jpg',cv2.IMREAD_COLOR)
        # Resize frame of video to 1/4 size for faster face recognition processing
        small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)

        # Convert the image from BGR color (which OpenCV uses) to RGB color (which face_recognition uses)
        rgb_small_frame = small_frame[:, :, ::-1]
        self.process_this_frame = True
        # Only process every other frame of video to save time
        if self.process_this_frame:
            # Find all the faces and face encodings in the current frame of video
            self.face_locations = face_recognition.face_locations(rgb_small_frame)
            self.face_encodings = face_recognition.face_encodings(rgb_small_frame, self.face_locations)

            self.face_names = []
            for face_encoding in self.face_encodings:
                # See if the face is a match for the known face(s)
                distances = face_recognition.face_distance(self.known_face_encodings, face_encoding)
                min_value = min(distances)

                # tolerance: How much distance between faces to consider it a match. Lower is more strict.
                # 0.6 is typical best performance.
                name = "Unknown"
                print(min_value)
                if min_value < 0.4:
                    index = np.argmin(distances)
                    name = self.known_face_names[index]
                self.face_names.append(name)


        self.process_this_frame = not self.process_this_frame

        # Display the results
        for (top, right, bottom, left), name in zip(self.face_locations, self.face_names):
            # Scale back up face locations since the frame we detected in was scaled to 1/4 size
            top *= 4
            right *= 4
            bottom *= 4
            left *= 4

            # Draw a box around the face
            cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)

            # Draw a label with a name below the face
            cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
            font = cv2.FONT_HERSHEY_DUPLEX
            cv2.putText(frame, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)

        return frame

    def get_jpg_bytes(self):
        frame = self.get_frame()
        # We are using Motion JPEG, but OpenCV defaults to capture raw images,
        # so we must encode it into JPEG in order to correctly display the
        # video stream.
        ret, jpg = cv2.imencode('.jpg', frame)
        return jpg.tobytes()


#if __name__ == '__main__':
    def startface(self):
        now = datetime.datetime.now().strftime("%m_%d_%H_%M_%S")
        face_recog = FaceRecog()
        print(face_recog.known_face_names)
        while True:
            frame = face_recog.get_frame()

            # show the frame
            cv2.imshow("Frame", frame)
            print("face_names : ", face_recog.face_names)
            conn = pymysql.connect(host='localhost', user='root', password='kdh7148167!', db='LogDB')
            if eq(face_recog.face_names[0], 'Unknown') :
                curs = conn.cursor()
                sql = "INSERT INTO UnknownLog(logDate,name) VALUES (%s,%s)"
                curs.execute(sql, (now, face_recog.face_names))
                conn.commit()
                conn.close()
                cv2.imwrite('D:\\Document\\Phyton\\Recognition\\UnknownLog\\' +now + '.jpg', frame)
                cv2.imwrite('C:\\Users\\GZ\\share\\unknown.jpg', frame)
                print("UnAuthenicated!")
                break
            else :
                curs=conn.cursor()
                sql="INSERT INTO KnownLog(logDate,name) VALUES (%s,%s)"
                curs.execute(sql, (now , face_recog.face_names))
                conn.commit()
                conn.close()
                cv2.imwrite('D:\\Document\\Phyton\\Recognition\\KnownLog\\' +now + '.jpg', frame)
                print("Authenicated!")
                break
            break
        # do a bit of cleanup
        cv2.destroyAllWindows()

        print('finish')
        return face_recog.face_names
