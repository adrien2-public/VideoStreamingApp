# This defines our starting point
FROM node
RUN mkdir /usr/src/app 
WORKDIR /usr/src/app
RUN npm install -g @angular/cli 
COPY . . 
CMD ["ng","serve","--host", "0.0.0.0", "--port", "8081"]

