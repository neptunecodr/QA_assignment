# QA_assignment

1. Rescale - file upload UI and API automation project with (Java, Selenium, TestNG and RestAssured) framework with log4j.
2. Automation framework folder structure,

- src/main,
      - all the Base classes for UI and API
      - Page Object model - all UI page functions
      
 - src/test: contains
       - All UI and API test case folder
       -  Test cases are written only for UI - Login page/ action / HomePage/ Filepage -
       - For API - contains happy path scenarios: GET files, Upload file and Delete file.
       
 POM.xml 
     - list all the dependencies for download required for this project framework.
     
 testng.xml
      -  List all the test suit and test parameters for base class
      - Used for test suite execution
      
Log4j.properties
     - contains all the log4j configuration
     
resources
     - contains drivers for Firefox and chrome drivers
