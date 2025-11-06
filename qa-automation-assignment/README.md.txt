QA Automation Assignment – Login Functionality (Selenium Java)

This project automates the login feature of a sample web application using Selenium WebDriver, Java, and TestNG. All instructions below are written as clear, manual steps — follow them one by one.


---

1. Objective (what you are submitting)

Automate five login scenarios for the demo site:

Valid login

Invalid username

Invalid password

Blank username & password

Logout functionality


The automation is written in Java using Selenium WebDriver and TestNG and follows Page Object Model (POM).


---

2. Prerequisites — Install these first (do them exactly)

1. Install Java JDK

Go to: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html (or use OpenJDK)

Download JDK 11 or later.

Install it.

After install, open Command Prompt (Windows) or Terminal (Mac/Linux) and type:

java -version

You should see Java version printed (e.g., `java version "11.0.x").



2. Install Maven

Download Maven from: https://maven.apache.org/download.cgi

Unzip and set MAVEN_HOME environment variable if required.

Add mvn to your PATH environment variable.

Verify by running:

mvn -v

You should see Maven version and Java version output.



3. Install an IDE

Install Eclipse or IntelliJ IDEA.

I used Eclipse in this project but either works fine.



4. Install Google Chrome

Install Google Chrome browser on your machine.

Open Chrome and check its version: in the address bar type:

chrome://settings/help

Note the major version number (example: 119, 120).





---

3. Download ChromeDriver (exact steps)

1. Open your browser and search: ChromeDriver download or go directly to:

https://chromedriver.chromium.org/downloads



2. Find the ChromeDriver version that matches the major version of your Chrome (the number from chrome://settings/help).


3. Download the ZIP file for Windows (or your OS).


4. Extract the downloaded .zip file. You will get chromedriver.exe (Windows) or chromedriver (Mac/Linux).


5. Move or copy the chromedriver.exe file to a permanent folder; for example:

C:\Drivers\chromedriver.exe

or on Mac/Linux:

/Users/yourname/Drivers/chromedriver


6. Confirm you can run the driver by opening a command prompt and running (Windows):

C:\Drivers\chromedriver.exe --version

It should print the ChromeDriver version.




---

4. Project files (where things are located in this repo)

Project root: qa-automation-assignment/

Important files and folders (exact layout):

qa-automation-assignment/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/qa/pages/LoginPage.java
│   └── test/
│       └── java/
│           └── com/qa/tests/LoginTest.java
└── test-output/       (generated after running tests)
    └── index.html


---

5. Check & update pom.xml (do this exactly)

1. Open pom.xml in the project root.


2. Make sure the following dependencies exist. If not, copy and paste them inside the <dependencies> section and save.



<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.21.0</version>
    </dependency>

    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

3. After saving, update Maven dependencies:

In Eclipse: Right-click project → Maven → Update Project... → Select project → OK.

Or run in terminal from project root:

mvn clean install





---

6. Set ChromeDriver path in your code (do this exactly)

1. Open your base test class file (example BaseTest.java) in:

src/test/java/com/qa/tests/BaseTest.java

or wherever you placed setup code.


2. At the start of setUp() method (or main if you used it), add exactly this line — replace the path with your actual chromedriver path:



System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

Windows example:

System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
WebDriver driver = new ChromeDriver();

Mac/Linux example:

System.setProperty("webdriver.chrome.driver", "/Users/yourname/Drivers/chromedriver");
WebDriver driver = new ChromeDriver();

3. Save the file.




---

7. Verify project compiles (do this next)

1. In IDE: Right-click the project → Run As → Maven build...

In Goals type: clean test

Click Run.



2. Or from terminal inside project root:

mvn clean test


3. If there are compile errors:

Read the error in console.

Most common issues: wrong package name, missing imports, or chromedriver path not set.

Fix the code or the path and repeat mvn clean test.





---

8. How to run tests (two ways — do both to confirm)

Option A — Run as TestNG from IDE (recommended step-by-step)

1. In Project Explorer, open: src/test/java/com/qa/tests/LoginTest.java.


2. Right-click LoginTest.java.


3. Select Run As → TestNG Test.


4. Watch Chrome open and tests run one by one.


5. After tests finish, check Console for pass/fail details.



Option B — Run with Maven from terminal

1. Open terminal in project root.


2. Run:

mvn test


3. Maven will run TestNG tests. Observe output in terminal.




---

9. View results and test report (exact steps)

1. After tests finish, open the test-output folder in project root.


2. Open the file:

test-output/index.html


3. The HTML report shows which tests passed and failed and stack traces for failures.




---

10. Exact test data used (copy into your submission if required)

Valid username: student

Valid password: Password123

Application URL: https://practicetestautomation.com/practice-test-login/



---

11. Troubleshooting — exact fixes for common errors

1. Browser not opening / SessionNotCreatedException

Cause: ChromeDriver version does not match Chrome version.

Fix: Download the matching ChromeDriver and update the path in System.setProperty.



2. java.lang.IllegalStateException: The driver executable does not exist

Cause: Wrong path to chromedriver.

Fix: Give full absolute path to chromedriver in System.setProperty. Example:

System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");



3. Maven fails to download dependencies

Cause: No internet access or wrong pom.xml.

Fix: Check internet connection, then run:

mvn dependency:resolve



4. Test fails because locator changed

Cause: Page changed or locator is wrong.

Fix: Open the website in Chrome, inspect element, update locator in LoginPage.java to the correct id, name, cssSelector, or xpath.





---

12. What to submit (exact list)

Zip the entire project folder qa-automation-assignment/ containing:

pom.xml

README.md (this file)

src/ folder with pages and tests

test-output/ (optional)


Then upload ZIP or push to GitHub and share the repository link.


---

13. Assignment author / contact (for submission)

Name: P. Ummar Farooq Role: QA Automation Trainee


---

14. Final notes (one final check list to tick before submission)

[ ] All 5 test methods exist and are in LoginTest.java

[ ] LoginPage.java contains locators + methods (POM)

[ ] BaseTest.java or setup code contains System.setProperty for ChromeDriver

[ ] pom.xml contains selenium-java and testng dependencies

[ ] Project builds with mvn clean test

[ ] test-output/index.html displays the report

[ ] README.md (this file) included in root

[ ] Project zipped or pushed to GitHub



---

