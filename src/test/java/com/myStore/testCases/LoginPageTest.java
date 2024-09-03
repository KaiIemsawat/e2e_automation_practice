package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

  LoginPage loginPage;
  IndexPage indexPage;
  HomePage homePage;

  @BeforeMethod
  public void setup() {
    launchApp();
    loginPage = new LoginPage();
    indexPage = new IndexPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void loginTest() throws InterruptedException {
    loginPage = indexPage.clickOnSignIn();
    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    String actualURL = homePage.getCurrentUrl();
    Assert.assertEquals(
        actualURL, "http://www.automationpractice.pl/index.php?controller=my-account");
  }
}
