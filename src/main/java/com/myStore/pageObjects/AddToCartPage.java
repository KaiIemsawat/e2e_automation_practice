package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
  @FindBy(id = "quantity_wanted")
  WebElement quantityInputBox;

  @FindBy(id = "group_1")
  WebElement size;

  @FindBy(xpath = "//p[@id='add_to_cart']/button")
  WebElement addToCartBtn;

  @FindBy(xpath = "//h2/i[@class='icon-check']")
  WebElement successfulAddedMessage;

  @FindBy(xpath = "Proceed to checkout")
  WebElement processToCheckoutBtn;

  public AddToCartPage() {
    PageFactory.initElements(driver, this);
  }

  public void enterQuantity(String quantity) {
    Action.type(quantityInputBox, quantity);
  }

  public void selectSize(String neededSize) {
    // use 'L' for needed size
    Action.selectByVisibleText(neededSize, size);
  }

  public void clickOnAddToCart() {
    Action.click(driver, addToCartBtn);
  }

  public boolean validateAddToCart() {
    return Action.isDisplay(driver, successfulAddedMessage);
  }

  public OrderPage clinkOnProcessToCheckout() {
    Action.jsClick(driver, processToCheckoutBtn);
    return new OrderPage();
  }
}
