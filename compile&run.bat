@ECHO OFF
SETLOCAL enableDelayedExpansion

echo ���뿪ʼ

SET cur_dir=%CD%

set project_file=%cur_dir%
set project_class=%cur_dir%\class

if exist %project_class% rmdir /s/q %project_class%
if not exist %project_class% mkdir %project_class%

cd %cur_dir%

for /R %%b in (*.java) do set JFILES=!JFILES! %%b

cd %cur_dir%

javac -d %project_class% -encoding utf-8 %JFILES%

echo �����������ʼ����

java -cp %project_class% basetest.MainEntrance

echo ���н���

pause