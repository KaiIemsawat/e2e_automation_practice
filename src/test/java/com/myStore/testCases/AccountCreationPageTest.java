package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AccountCreationPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {

  IndexPage indexPage;
  LoginPage loginPage;
  AccountCreationPage accountCreationPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    indexPage = new IndexPage();
    loginPage = new LoginPage();
    accountCreationPage = new AccountCreationPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void verifyCreateAccountPage() {
    indexPage = new IndexPage();
    indexPage.clickOnSignIn();
    accountCreationPage = loginPage.createAccount("testemail191919@email.com");
    Assert.assertTrue(accountCreationPage.validateAccountCreatePage());
  }
}
