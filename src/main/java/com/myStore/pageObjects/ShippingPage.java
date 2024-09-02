package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

  @FindBy(id = "cgv")
  WebElement agreeCheckbox;

  @FindBy(xpath = "//button[@name='processCarrier']")
  WebElement processToCheckoutBtn;

  public ShippingPage() {
    PageFactory.initElements(driver, this);
  }

  public void selectCheckBox() {
    Action.click(driver, agreeCheckbox);
  }

  public PaymentPage clickProceedToCheckout() {
    Action.click(driver, processToCheckoutBtn);
    return new PaymentPage();
  }
}
