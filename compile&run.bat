@ECHO OFF
SETLOCAL enableDelayedExpansion

echo 编译开始

SET cur_dir=%CD%

set project_file=%cur_dir%
set project_class=%cur_dir%\class

if exist %project_class% rmdir /s/q %project_class%
if not exist %project_class% mkdir %project_class%

cd %cur_dir%

for /R %%b in (*.java) do set JFILES=!JFILES! %%b

cd %cur_dir%

javac -d %project_class% -encoding utf-8 %JFILES%

echo 编译结束，开始运行

java -cp %project_class% basetest.MainEntrance

echo 运行结束

pause