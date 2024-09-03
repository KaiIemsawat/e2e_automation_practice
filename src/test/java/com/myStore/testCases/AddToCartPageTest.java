package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AddToCartPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

  IndexPage indexPage;
  SearchResultPage searchResultPage;
  AddToCartPage addToCartPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    indexPage = new IndexPage();
    searchResultPage = new SearchResultPage();
    addToCartPage = new AddToCartPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void addToCartPageTest() {
    indexPage.clickOnSearchWithEmptyInput();
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    addToCartPage = searchResultPage.selectBlouse();
    Assert.assertTrue(addToCartPage.validateAddToCatPage());
  }

  @Test
  public void addToCartTest() throws InterruptedException {
    indexPage.clickOnSearchWithEmptyInput();
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    addToCartPage = searchResultPage.selectBlouse();
    addToCartPage.selectingSize("L");
    Thread.sleep(1000);
    addToCartPage.selectingColorBlack();
    addToCartPage.enterQuantity("2");
    //    Thread.sleep(3000);
    addToCartPage.clickOnAddToCart();
    Thread.sleep(3000);
    Assert.assertTrue(addToCartPage.validateAddedToCart());
  }
}
