package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

  @FindBy(xpath = "//a[@class='product_img_link']")
  WebElement resultProduct;

  public SearchResultPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean validateIsProductAvailable() {
    return Action.isDisplayed(driver, resultProduct);
  }

  public AddToCartPage selectResultProduct() {
    Action.click(driver, resultProduct);
    return new AddToCartPage();
  }
}
