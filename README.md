# engageSmart
UI test automation for the project

Tools & versions

// automation script written i java languge
Jave - 17

//for test execution and verification used testng
TestNG -7.4.0

// to coonect browser and as a UI automation tool used selenium webdriver
Selenium - 4.4.0

// for driver managemnt and set up used BoniGarcia Webdriver Manager
BoniGarcia Webdriver Manager - 5.3.0


To Execute Code:

1. Right Click to testng.xml file and Run as testng.xml file
2. Right Click to herokuappUITestAutomation under src/test folder and Run


Reporting: TestNg provides emailable and failed.xml report files under test-output folder.
To be able to generate reports we need to configure runners and add defoult reporter. Please follow below instructions:
-- Right click testng.xml file or herokuappUITestAutomation.java class
-- Click Modify Run Configurations
-- Click Listeners and scroll down to find Use defoult Reporters
-- Put checkmark to "Use defoult Reporeters" ,then apply and click OK.
-- Run Test case and refresh the project to see reports.
