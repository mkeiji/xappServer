# The App Server
*TODO: Description of service goes here.*


## Requirements
1. [java 14 - open JDK 14](https://jdk.java.net/14/)
2. [gradle 6.5.1](https://gradle.org/)
3. [mySql 5.7](https://dev.mysql.com/downloads/windows/installer/5.7.html)
4. [project lombok plugin on your IDE/text-editor](https://projectlombok.org/)


## Development
### Recommended
The easiest way to have the lombok plugin is via one of these IDE/editors:
1. [IntelliJ](https://www.jetbrains.com/idea/) (there is a community version that is FREE) 
2. [VScode](https://code.visualstudio.com/) (its free)

### Preparation
Before running the server, you MUST create and start the database server.
For development use the following:
* database=xapptestdb
* username=root
* password=root

### To run
* windows
``` bash
gradlew bootRun
```
> NOTE: if it doesnt work, try running `cmd` as Administrator

* linux
``` bash
./gradlew bootRun
```
* IDE/editor: just run the `ServerApplication` file.

Service will listen at [localhost:8080](http://localhost:8080/)
> NOTE: The service by default expects to find an SQL Server instance at `localhost:3306`.
> The database configuration location is: `application.properties`.
> IMPORTANT: Make sure you have your mySql server configured and running

### To run unit tests
``` bash
gradlew test
```
