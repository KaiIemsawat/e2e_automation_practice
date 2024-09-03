package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

  IndexPage indexPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    indexPage = new IndexPage();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void verifyPhone() {
    Assert.assertTrue(indexPage.validatePhone());
  }

  @Test
  public void verifyTitle() {
    Assert.assertEquals(indexPage.getIndexPageTitle(), "My Shop");
  }

  @Test
  public void verifySearchInput() {
    Assert.assertTrue(indexPage.validateSearchInput());
  }
}
