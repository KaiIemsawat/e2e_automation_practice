package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

  @FindBy(xpath = "//a[class='login']")
  WebElement signInBtn;

  @FindBy(xpath = "//img[@class='logo img-responsive']")
  WebElement myStoreLogo;

  @FindBy(id = "searchbox")
  WebElement searchProductInoutBox;

  @FindBy(name = "submit_search")
  WebElement searchProductBtn;

  public IndexPage() {
    PageFactory.initElements(driver, this);
  }

  public LoginPage clickOnSignIn() {
    Action.click(driver, signInBtn);
    return new LoginPage();
  }

  public boolean validateLogo() {
    return Action.isDisplay(driver, myStoreLogo);
  }

  public String getIndexPageTitle() {
    return Action.getTitle(driver);
  }

  public SearchResultPage searchProduct(String productSearchTerm) {
    Action.type(searchProductInoutBox, productSearchTerm);
    Action.click(driver, searchProductBtn);
    return new SearchResultPage();
  }
}
