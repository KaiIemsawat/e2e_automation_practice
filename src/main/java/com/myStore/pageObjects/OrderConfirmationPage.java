package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {
  @FindBy(xpath = "//p[@class='alert alert-success']")
  WebElement orderCompleteMessage;

  public OrderConfirmationPage() {
    PageFactory.initElements(driver, this);
  }

  public String validateConfirmMessage() {
    return orderCompleteMessage.getText();
  }
}
