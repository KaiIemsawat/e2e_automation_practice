package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

  @FindBy(xpath = "//a[@class='product_img_link']")
  WebElement resultProduct;

  @FindBy(xpath = "//p[@class='alert alert-warning']")
  WebElement alertMessage;

  @FindBy(
      xpath =
          "//li[@class='clearfix']/div[@class='product-content']/h5/a[contains(text(), 'Blouse')]")
  WebElement blouseLink;

  public SearchResultPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean validateIsProductAvailable() {
    return Action.isDisplayed(driver, resultProduct);
  }

  public AddToCartPage selectBlouse() {
    Action.click(driver, blouseLink);
    return new AddToCartPage();
  }

  public boolean verifyAlertMessage() {
    return Action.isDisplayed(driver, alertMessage);
  }

  public boolean verifyBlouseIsAvailable() {
    return Action.isDisplayed(driver, blouseLink);
  }
}
