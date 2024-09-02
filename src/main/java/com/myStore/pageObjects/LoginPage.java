package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

  @FindBy(id = "email_create")
  WebElement createAccountEmailInput;

  @FindBy(id = "email")
  WebElement loginEmailInput;

  @FindBy(id = "passwd")
  WebElement passwordInput;

  @FindBy(id = "SubmitCreate")
  WebElement submitCreateAccountBtn;

  @FindBy(id = "SubmitLogin")
  WebElement submitSignInBtn;
}
