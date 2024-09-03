package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
  IndexPage indexPage;
  SearchResultPage searchResultPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    indexPage = new IndexPage();
    searchResultPage = new SearchResultPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void verifySearchPage() {
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    Assert.assertTrue(searchResultPage.verifyAlertMessage());
  }

  @Test
  public void verifyBlouseDisplay() {
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    Assert.assertTrue(searchResultPage.verifyBlouseIsAvailable());
  }
}
