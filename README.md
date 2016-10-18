# SpringBoot-REST-Swagger-Example
Sample REST Interface via Spring Boot and Swagger


A simple sample application that demonstrates the creation of a REST API Service running on SpringBoot
integrated with Swagger.

## Build the Sample Application
Run **gradle build**

## Run the Sample Application
Run **gradle bootRun**


## Access Swagger UI
After starting the application, open **http://localhost:8080/swagger-ui.html** in a browser.

## Testing Response
When testing in Swagger, use the **candidateId = 1** to get a 200 response. 
Use the **candidateId = 2** to get a 400 (Bad Request) response. 
Use the **candidateId = 3** to get a 500 (Internal Server Error) response. 
Use the **candidateId = 4** to get a 404 (Not Found) response. 

## Importing into Eclipse
If you'd like to import this project into Eclipse, you need to first generate the eclipse
project files.  To do so, run the following command **gradle eclipse**

If you are running the Buildship plugin for Gradle in Eclipse, after importing the project, you
can add the Gradle nature to the project by selecting  **Configure --> Add Gradle Nature**