package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

  @FindBy(id = "layer_cart_product_price")
  WebElement productPrice;

  @FindBy(id = "cart_title")
  WebElement cartTitle;

  @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
  WebElement proceedToCheckOutBtn;

  @FindBy(xpath = "//a[@title='Continue shopping']")
  WebElement continueShoppingBtn;

  @FindBy(id = "total_price")
  WebElement totalPrice;

  public OrderPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean getCartTitle() {
    System.out.println("Raw cart title : " + cartTitle.getText());
    String actualTitle = cartTitle.getText();
    return cartTitle.getText().contains(cartTitle.getText());
  }

  public double getUnitPrice() {
    String priceNoSign = productPrice.getText().substring(1);
    System.out.println("unit price : " + priceNoSign);
    return Double.parseDouble(priceNoSign);
  }

  public double getTotalPrice() {
    String totalSummaryPrice = totalPrice.getText().substring(1);
    return Double.parseDouble(totalSummaryPrice);
  }

  public LoginPage clickOnProceedToCheckOut() {
    Action.click(driver, proceedToCheckOutBtn);
    return new LoginPage();
  }
}
