package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
  IndexPage indexPage;
  HomePage homePage;
  LoginPage loginPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    homePage = new HomePage();
    indexPage = new IndexPage();
    loginPage = new LoginPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void verifyMyAddressBtn() {
    loginPage = indexPage.clickOnSignIn();
    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    Assert.assertTrue(homePage.validateMyAddressBtn());
  }

  @Test
  public void verifyOrderHistoryBtn() {
    loginPage = indexPage.clickOnSignIn();
    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    Assert.assertTrue(homePage.validateOrderHistoryAndDetailsBtn());
  }
}
