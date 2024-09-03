package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

  @FindBy(xpath = "//a[@class='login']")
  WebElement signInBtn;

  @FindBy(xpath = "//span[@class='shop-phone']/strong")
  WebElement storePhone;

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

  public boolean validatePhone() {
    return Action.isDisplayed(driver, storePhone);
  }

  public String getIndexPageTitle() {
    return Action.getTitle(driver);
  }

  public SearchResultPage searchProduct(String productSearchTerm) {
    //    User 'Blouse' for search
    Action.type(searchProductInoutBox, productSearchTerm);
    Action.click(driver, searchProductBtn);
    return new SearchResultPage();
  }
}
