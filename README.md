# VideoStreamingApp

## Table of contents
* [Setup](#setup)

	
## Setup
To run this project, do the below:

1) Download github folder and turn on docker Desktop

2) After unzipping above folder open it, and run the below command in the current (main directory) directory
```
$ docker compose up
```

3) If cURL is not installed on computer, download it, instructions below:
```
(https://help.ubidots.com/en/articles/2165289-learn-how-to-install-run-curl-on-windows-macosx-linux)
```

4) If using linux, use the below commands to perform the creation of consumers, services and credentials in our Kong API gateway. It might
be preferable for some to simply copy paste contents from the file to the command line

```
$ chmod +x linuxExecute.sh
$ ./linuxExecute.sh
```

5) If using windows, use the below commands to perform the creation of consumers, services and credentials in our Kong API gateway. It might
be preferable for some to simply copy paste contents from the file to the command line

```
$ windowsExecute.bat
```

6) Open up browser window at 
```
(http://lolcalhost:8081)
```
7) Use credentials of John Smith for login , credentials are found in the kong credentials file

```
 username = John17100	
 password = monday@500
```


