package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

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

  public LoginPage() {
    PageFactory.initElements(driver, this);
  }

  public HomePage login(String email, String password) {
    Action.type(loginEmailInput, email);
    Action.type(passwordInput, password);
    Action.click(driver, submitSignInBtn);
    return new HomePage();
  }

  public AddressPage loginWhileCheckout(String email, String password) {
    Action.type(loginEmailInput, email);
    Action.type(passwordInput, password);
    Action.click(driver, submitSignInBtn);
    return new AddressPage();
  }

  public AccountCreationPage createAccount(String email) {
    Action.type(createAccountEmailInput, email);
    Action.click(driver, submitCreateAccountBtn);
    return new AccountCreationPage();
  }
}
