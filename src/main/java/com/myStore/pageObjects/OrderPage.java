package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

  @FindBy(xpath = "//li[@class='price']")
  WebElement unitPrice;

  @FindBy(xpath = "//tr[@class='cart_total_delivery']/td[@class='price']")
  WebElement shippingPrice;

  @FindBy(id = "total_price")
  WebElement totalPrice;

  @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
  WebElement proceedToCheckOutBtn;

  public OrderPage() {
    PageFactory.initElements(driver, this);
  }

  public double getUnitPrice() {
    String priceNoSign = unitPrice.getText().substring(1);
    return Double.parseDouble(priceNoSign);
  }

  public LoginPage clickOnProceedToCheckOut() {
    Action.click(driver, proceedToCheckOutBtn);
    return new LoginPage();
  }
}
