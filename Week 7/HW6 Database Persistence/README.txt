//CAMPUS TASK BOARD API

== PROJECT DESCRIPTION ==
A Spring Boot REST API that allows users to create, read, update, and delete tasks.
For Homework 6, the project was updated to use Spring Data JPA and an H2 database. Tasks are now saved in a database while the application is running. The API also supports filtering, searching, pagination, and sorting.


== TECHNOLOGIES USED ==
Java 21
Spring Boot
Spring Web
Spring Data JPA
H2 Database
Spring Validation
Lombok
Maven
Postman


== HOW TO RUN THE APPLICATION ==
1. Open project file in IDE
2. Run CampusTaskboardApplication.java
3. Go to http://localhost:8080 in browser
4. Use Postman to test the API endpoints


== API ENDPOINTS DOCUMENTATION ==
GET /api/tasks
POST /api/tasks
GET /api/tasks/{id}
PUT /api/tasks/{id}
DELETE /api/tasks/{id}


== HOMEWORK 6 NEW ENDPOINTS ==
GET /api/tasks/completed
GET /api/tasks/incomplete
GET /api/tasks/priority/{priority}
GET /api/tasks/search?keyword={keyword}
GET /api/tasks/paginated?page={page}&size={size}&sortBy={field}


== SCREENSHOTS INCLUDED ==
POST /api/tasks creating a task
GET /api/tasks showing all tasks
GET /api/tasks/completed
GET /api/tasks/incomplete
GET /api/tasks/priority/HIGH
GET /api/tasks/search?keyword=homework
GET /api/tasks/paginated?page=0&size=5&sortBy=title
H2 console showing SELECT * FROM tasks;


== VIDEO LINK ==
https://drive.google.com/file/d/1YQFN91PUtBbLwjm8GwPNOrBtepUcTrhM/view?usp=sharing