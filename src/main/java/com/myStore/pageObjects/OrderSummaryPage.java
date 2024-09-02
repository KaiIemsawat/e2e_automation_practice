package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BaseClass {
  @FindBy(xpath = "//button[@type='submit' and @class='button btn btn-default button-medium']")
  WebElement confirmOrderBtn;

  public OrderSummaryPage() {
    PageFactory.initElements(driver, this);
  }

  public OrderConfirmationPage clickOnConfirmOrder() {
    Action.click(driver, confirmOrderBtn);
    return new OrderConfirmationPage();
  }
}
