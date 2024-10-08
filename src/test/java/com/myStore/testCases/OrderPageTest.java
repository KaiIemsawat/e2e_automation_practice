package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

  IndexPage indexPage;
  SearchResultPage searchResultPage;
  AddToCartPage addToCartPage;
  OrderPage orderPage;

  @BeforeMethod
  public void setup() {
    launchApp();
    indexPage = new IndexPage();
    searchResultPage = new SearchResultPage();
    addToCartPage = new AddToCartPage();
    orderPage = new OrderPage();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void verifyTotalCost() throws InterruptedException {
    indexPage.clickOnSearchWithEmptyInput();
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    addToCartPage = searchResultPage.selectBlouse();
    addToCartPage.selectingSize("L");
    addToCartPage.selectingColorBlack();
    addToCartPage.enterQuantity("2");
    addToCartPage.clickOnAddToCart();
    orderPage = addToCartPage.clinkOnProcessToCheckout();
    Assert.assertTrue(orderPage.getCartTitle());
  }

  @Test
  public void verifyTotalPrice() throws InterruptedException {
    indexPage.clickOnSearchWithEmptyInput();
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    addToCartPage = searchResultPage.selectBlouse();
    addToCartPage.selectingSize("L");
    addToCartPage.selectingColorBlack();
    addToCartPage.enterQuantity("2");
    addToCartPage.clickOnAddToCart();
    double totalPrice = addToCartPage.getTotalPrice();
    orderPage = addToCartPage.clinkOnProcessToCheckout();
    Assert.assertEquals(totalPrice, orderPage.getTotalPrice());
  }
}
