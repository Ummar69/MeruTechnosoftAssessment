package com.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage login;

    @BeforeClass
    public void setUpBrowser() {
        setUp();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validLogin() {
        login.enterUsername("student");
        login.enterPassword("Password123");
        login.clickLogin();
        Assert.assertTrue(login.getSuccessMessage().contains("Logged In Successfully"));
    }

    @Test(priority = 2)
    public void invalidUsername() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login.enterUsername("wrongUser");
        login.enterPassword("Password123");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("Your username is invalid"));
    }

    @Test(priority = 3)
    public void invalidPassword() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login.enterUsername("student");
        login.enterPassword("wrongPass");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("Your password is invalid"));
    }

    
    @Test(priority = 4)
    public void blankUsernameAndPassword() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login.enterUsername("");
        login.enterPassword("");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("Your username is invalid"),
            "Expected error message for blank username/password not displayed.");
    }

  
    @Test(priority = 5)
    public void logoutFunctionality() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login.enterUsername("student");
        login.enterPassword("Password123");
        login.clickLogin();

       
        driver.findElement(By.linkText("Log out")).click();

        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practice-test-login"),
            "Logout was not successful; user not returned to login page.");
    }

    @AfterClass
    public void closeBrowser() {
        tearDown();
    }
}
