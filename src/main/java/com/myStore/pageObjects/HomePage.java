package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

  @FindBy(xpath = "//a[@title='Addresses']")
  WebElement myAddressBtn;

  @FindBy(xpath = "//a[@title='Orders']")
  WebElement orderHistoryAndDetailsBtn;

  public HomePage() {
    PageFactory.initElements(driver, this);
  }

  public boolean validateMyAddressBtn() {
    return Action.isDisplayed(driver, myAddressBtn);
  }

  public boolean validateOrderHistoryAndDetailsBtn() {
    return Action.isDisplayed(driver, orderHistoryAndDetailsBtn);
  }
}
