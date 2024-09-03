package com.myStore.pageObjects;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BaseClass {
  @FindBy(id = "quantity_wanted")
  WebElement quantityInputBox;

  @FindBy(id = "group_1")
  WebElement size;

  @FindBy(id = "color_11")
  WebElement selectColorBlack;

  @FindBy(xpath = "//p[@id='add_to_cart']/button")
  WebElement addToCartBtn;

  @FindBy(xpath = "//h2/i[@class='icon-check']")
  WebElement successfulAddedMessage;

  @FindBy(xpath = "Proceed to checkout")
  WebElement processToCheckoutBtn;

  @FindBy(xpath = "//h3[@class='page-product-heading']")
  WebElement dataSheet;

  public AddToCartPage() {
    PageFactory.initElements(driver, this);
  }

  public void enterQuantity(String quantity) throws InterruptedException {
    Action.type(quantityInputBox, quantity);
  }

  public void selectingColorBlack() {
    Action.click(driver, selectColorBlack);
  }

  public void clickOnDropdown() {
    Action.click(driver, size);
  }

  public void clickOnAddToCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
    Action.click(driver, addToCartBtn);
  }

  public boolean validateAddedToCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(successfulAddedMessage));
    return Action.isDisplayed(driver, successfulAddedMessage);
  }

  public OrderPage clinkOnProcessToCheckout() {
    Action.jsClick(driver, processToCheckoutBtn);
    return new OrderPage();
  }

  public boolean validateAddToCatPage() {
    return Action.isDisplayed(driver, dataSheet);
  }

  public void selectingSize(String selectSize) {
    // Use 'L'
    Action.selectByVisibleText(selectSize, size);
  }
}
