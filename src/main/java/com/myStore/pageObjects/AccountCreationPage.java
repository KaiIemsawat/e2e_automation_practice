package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

  @FindBy(xpath = "//h1[@class='page-heading']")
  WebElement createAccountHeader;

  public AccountCreationPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean validateAccountCreatePage() {
    return Action.isDisplay(driver, createAccountHeader);
  }
}
