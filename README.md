# Genplug-API

# Authors: 
* Catherine Muthoni
* Elnaam Umutoni

# Project Description
This is the API for GenPlug Web Application, a wellness application aimed at promoting a more informative society.

# Technologies Used:
* Apache Tomcat
* Spring Web Framework
* ClearDB
* Heroku

# Setup Requirements
* Maven
* Java JDK 1.8 and above

# How to run/launch app
<p>This API is already hosted on Heroku and has been set as the default api for the UI application. The link to the hosted api is <a>https://genplug-api.herokuapp.com</a>. To launch the whole application, go to <a>https://github.com/cate865/genplug_frontend</a> and click the link to launch the app</p>
<strong><p>If you intend to launch the app manually, follow the following steps:</p></strong>
<p>Clone this repository to your local machine</p>
<p>Windows machine - type the following command on your terminal to start a session: <strong>mvnw spring-boot:run</strong></p>
<p>Linux machine - type the following command: <strong>mvn spring-boot:run</strong></p>

<p>The session will begin on port 8080(default) but you can change it in the application.properties file.</p>

<p>Ensure you change the baseUrl in the index.js file in the frontend(link to repo above) to <a>http://localhost:8080</a>. To use the hosted api, set the baseUrl to the heroku link given above. </p>
<p>The database details are indicated on the application.properties file if you need to access it.</p>
<p>The urls can be tested using Postman</p>





