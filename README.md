# Registeration-Automation-Task
Selenuim Framework Project using Java , Testng , Maven , POM and DDT
Framework contain ->(Src/main/java),(Src/test/java)
(Src/main/java) → contain pages.
(Src/test/java) →contain data, tests, utilities
 Screenshots Folder→ that contain screenshot if test case failed
Drivers Folder that contain (chrome, Internet explorer, Firefox)
drivers.
Test-output folder → contain (ExtentStepLogs.html, emailablereport.html) they are the execution reports that contain status of
each step-in test case.
Pom.xml → contain all dependencies used in project
#############################################################################


*Pages → contain two pages(Base page, Registeration page)
-Base page → contain base class that contain constructor to initiate driver and contain main methods I will use in another pages.
-Registeration page → fill all fields for registeration
*Data→ contain (excel sheet, ExcelReaderClass)
-Data→ contain Data that will used 
-ExcellReaderClass → Read data from excel sheet
*Tests → contain (Base Tests, Rgister test)
- Base Tests → contain methods that should run before/after (Class and method and test)
- Rgister Test → contain test Scenario and data provider thatread from excel sheet and also log each step in the test cass and register to the site 

####################################################################################

Steps to run:


1.open Register Test and Run 


2.Rgister Test  Run test case on chrome.


3.To show report open from test-output
• ExtentStepLogs.html
• Emailable-report.html


4. if there is any failure open folder ScreenShot to see the error 
5. if you want to change data open folder Data then open excell sheet and change data .
########################################################################


Note :
when user Register Successfully and Navigate to another page after sign up there is a limitaion on website that i couldnot do automation in this page and I want to check 
if registerd successfuly through logout button annd becuse of this limitaion i considered when he press on button sign up and navigate to another page that registered successfully 
