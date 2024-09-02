package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
  @FindBy(xpath = "//a[@title='Pay by bank wire']")
  WebElement payByBankWireBtn;

  @FindBy(xpath = "//a[@title='Pay by check.']")
  WebElement payByCheckBtn;

  public PaymentPage() {
    PageFactory.initElements(driver, this);
  }

  public OrderSummaryPage clickOnBankWire() {
    Action.click(driver, payByBankWireBtn);
    return new OrderSummaryPage();
  }
}
