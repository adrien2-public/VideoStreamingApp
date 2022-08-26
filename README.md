# VideoStreamingApp

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is simple Lorem ipsum dolor generator.
	
## Technologies
Project is created with:
* Lorem version: 12.3
* Ipsum version: 2.33
* Ament library version: 999
	
## Setup
To run this project, do the below:

1) Download github folder and turn on docker Desktop

2) After unzipping above folder open it, and run the below command in the current (main directory) directory
```
$ docker compose up
```

3) If cURL is not installed on computer, download it, instructions below:
https://help.ubidots.com/en/articles/2165289-learn-how-to-install-run-curl-on-windows-macosx-linux


4 A) If using linux, use the below commands to perform the creation of consumers, services and credentials in our Kong API gateway. It might
be preferable for some to simply copy paste contents from the file to the command line

```
$ chmod +x linuxExecute.sh
$ ./linuxExecute.sh
```

4 B) If using windows, use the below commands to perform the creation of consumers, services and credentials in our Kong API gateway. It might
be preferable for some to simply copy paste contents from the file to the command line

```
$ windowsExecute.bat
```

5) Open up browser window at http://lolcalhost:8081

6) Use credentials of John Smith for login , credentials are found in the kong credentials file




