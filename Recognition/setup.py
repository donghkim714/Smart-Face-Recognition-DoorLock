import sys
from cx_Freeze import setup, Executable

setup(
    name="D:/Document/face_recog",
    version="1,0",
    description="테스트 파일",
    author="60sec",
    executables=[Executable("face_recog.py")]
)