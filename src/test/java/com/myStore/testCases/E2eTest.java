package com.myStore.testCases;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E2eTest extends BaseClass {
  IndexPage indexPage;
  SearchResultPage searchResultPage;
  AddToCartPage addToCartPage;
  OrderPage orderPage;
  LoginPage loginPage;
  AddressPage addressPage;
  ShippingPage shippingPage;
  PaymentPage paymentPage;
  OrderSummaryPage orderSummaryPage;
  OrderConfirmationPage orderConfirmationPage;

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
  public void endToEndTest() throws InterruptedException {
    indexPage.clickOnSearchWithEmptyInput();
    searchResultPage = indexPage.clickOnSearchWithEmptyInput();
    addToCartPage = searchResultPage.selectBlouse();
    addToCartPage.selectingSize("L");
    addToCartPage.selectingColorBlack();
    addToCartPage.enterQuantity("2");
    addToCartPage.clickOnAddToCart();
    orderPage = addToCartPage.clinkOnProcessToCheckout();
    loginPage = orderPage.clickOnProceedToCheckOut();
    addressPage =
        loginPage.loginWhileCheckout(prop.getProperty("username"), prop.getProperty("password"));
    shippingPage = addressPage.clickOnCheckout();
    shippingPage.selectCheckBox();
    paymentPage = shippingPage.clickProceedToCheckout();
    orderSummaryPage = paymentPage.clickOnBankWire();
    orderConfirmationPage = orderSummaryPage.clickOnConfirmOrder();
    Assert.assertTrue(
        orderConfirmationPage
            .validateConfirmMessage()
            .equals("Your order on My Shop is complete."));
  }
}
