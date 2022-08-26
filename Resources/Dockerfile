
FROM httpd:latest
RUN apt update
RUN apt -y upgrade 
RUN apt-get -y install ffmpeg
RUN apt-get install bash
COPY htdocs/*  htdocs/
COPY httpd.conf  conf/
#RUN mkdir Videos
COPY packager-linux-x64   packager-linux-x64
COPY myscript.sh   myscript.sh
RUN sed -i 's/\r$//' myscript.sh
#RUN bash myscript.sh &
ENTRYPOINT ["httpd-foreground"]








