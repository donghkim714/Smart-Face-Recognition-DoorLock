from django.http import HttpResponse
from django.http import HttpResponseRedirect
from django.shortcuts import redirect
from FaceDetect import face_recog
from operator import eq


def hello(request):
    face = face_recog.FaceRecog()
    fff = face.startface()
    print(fff)
    if eq(fff[0],'Unknown') :
        return redirect("http://192.168.43.158/secondPass.php")
    else :
        return redirect('http://192.168.43.158/open.php')
