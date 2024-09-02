package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

  @FindBy(xpath = "//button[@name='processAddress']")
  WebElement processToCheckoutBtn;

  public AddressPage() {
    PageFactory.initElements(driver, this);
  }

  public ShippingPage clickOnCheckout() {
    Action.click(driver, processToCheckoutBtn);
    return new ShippingPage();
  }
}
