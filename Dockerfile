#FROM java:8u111-jre-alpine
#FROM microsoft/nanoserver:10.0.14393.1770_zh-tw AS windows-java1.8.0_91-docker
FROM microsoft/nanoserver

#RUN powershell -Command iwr 'http://javadl.oracle.com/webapps/download/AutoDL?BundleId=210185' -Outfile 'C:\jre-8u91-windows-x64.exe'
#RUN powershell start-process -filepath C:\jre-8u91-windows-x64.exe -passthru -wait -argumentlist "/s,INSTALLDIR=c:\Java\jre1.8.0_91,/L,install64.log"
#RUN del C:\jre-8u91-windows-x64.exe


#ENTRYPOINT["c:\\Java\\jre1.8.0_91\\bin\\java","-jar","c:\\ZkSample.jar"]
#CMD [ "c:\\Java\\jre1.8.0_91\\bin\\java.exe", "-version"]

#CMD [ "c:\\Java\\jre1.8.0_91\\bin\\java.exe", "-jar","c:\\ZkSample.jar"]

SHELL ["powershell", "-Command", "$ErrorActionPreference = 'Stop'; $ProgressPreference = 'SilentlyContinue';"]

ENV JAVA_HOME C:\\ojdkbuild
RUN $newPath = ('{0}\bin;{1}' -f $env:JAVA_HOME, $env:PATH); \
	Write-Host ('Updating PATH: {0}' -f $newPath); \
# Nano Server does not have "[Environment]::SetEnvironmentVariable()"
	setx /M PATH $newPath;

# https://github.com/ojdkbuild/ojdkbuild/releases
ENV JAVA_VERSION 8u131
ENV JAVA_OJDKBUILD_VERSION 1.8.0.131-1
ENV JAVA_OJDKBUILD_ZIP java-1.8.0-openjdk-1.8.0.131-1.b11.ojdkbuild.windows.x86_64.zip
ENV JAVA_OJDKBUILD_SHA256 7e7384636054001499ba96d55c90fc39cbb0441281254a1e9ac8510b527a7a46

RUN $url = ('https://github.com/ojdkbuild/ojdkbuild/releases/download/{0}/{1}' -f $env:JAVA_OJDKBUILD_VERSION, $env:JAVA_OJDKBUILD_ZIP); \
	Write-Host ('Downloading {0} ...' -f $url); \
	Invoke-WebRequest -Uri $url -OutFile 'ojdkbuild.zip'; \
	Write-Host ('Verifying sha256 ({0}) ...' -f $env:JAVA_OJDKBUILD_SHA256); \
	if ((Get-FileHash ojdkbuild.zip -Algorithm sha256).Hash -ne $env:JAVA_OJDKBUILD_SHA256) { \
		Write-Host 'FAILED!'; \
		exit 1; \
	}; \
	\
	Write-Host 'Expanding ...'; \
	Expand-Archive ojdkbuild.zip -DestinationPath C:\; \
	\
	Write-Host 'Renaming ...'; \
	Move-Item \
		-Path ('C:\{0}' -f ($env:JAVA_OJDKBUILD_ZIP -Replace '.zip$', '')) \
		-Destination $env:JAVA_HOME \
	; \
	\
	Write-Host 'Verifying install ...'; \
	Write-Host '  java -version'; java -version; \
	Write-Host '  javac -version'; javac -version; \
	\
	Write-Host 'Removing ...'; \
	Remove-Item ojdkbuild.zip -Force; \
	\
	Write-Host 'Complete.';

#RUN $url = ("http://ftp.twaren.net/Unix/Web/apache/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23-windows-x64.zip"); \
#	$output = "C:\\apache-tomcat-8.5.23-windows-x64.zip"; \
#	$start_time = Get-Date; \
#	Invoke-WebRequest -Uri $url -OutFile $output \
#	Write-Output "Time taken: $((Get-Date).Subtract($start_time).Seconds) second(s)" \	
#CMD [ "c:\\ojdkbuild\\bin\\java.exe", "-version"] 
CMD [ "ECHO" "Hello World"]