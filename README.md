# Spring Boot Upload Files

1.Import Project on the IDE.

2.Execute from MySQL command line -> 
create database TestDB; 
use database TestDB;

3.Right click project -> Run as Java Application or 
## Run Spring Boot application
mvn spring-boot:run

4. Test different CRUD operations on different endpoints like : 
POST /upload
GET /files
GET /files/{id}
DELETE /file/{id}/delete
using Swagger : http://localhost:8080/swagger-ui.html#!/file-controller/getListFilesUsingGET

