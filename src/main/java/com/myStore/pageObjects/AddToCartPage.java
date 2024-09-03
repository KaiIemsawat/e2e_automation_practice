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

  @FindBy(xpath = "//a[@title='Proceed to checkout']")
  WebElement processToCheckoutBtn;

  @FindBy(xpath = "//h3[@class='page-product-heading']")
  WebElement dataSheet;

  @FindBy(id = "our_price_display")
  WebElement productPrice;

  @FindBy(id = "layer_cart_product_quantity")
  WebElement quantity;

  @FindBy(xpath = "//span[@class='ajax_block_cart_total']")
  WebElement totalProductPrice;

  @FindBy(xpath = "//span[@class='ajax_cart_shipping_cost unvisible']")
  WebElement shippingPrice;

  public AddToCartPage() {
    PageFactory.initElements(driver, this);
  }

  public double getSingleProductPrice() {
    String prodPrice = productPrice.getText().substring(1);
    System.out.println("Single unit price : " + prodPrice);
    return Double.parseDouble(prodPrice);
  }

  public void enterQuantity(String quantity) throws InterruptedException {
    Action.type(quantityInputBox, quantity);
  }

  public void selectingColorBlack() throws InterruptedException {
    Thread.sleep(1000);
    Action.click(driver, selectColorBlack);
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

  public OrderPage clinkOnProcessToCheckout() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(processToCheckoutBtn));
    Action.jsClick(driver, processToCheckoutBtn);
    Thread.sleep(3000);
    return new OrderPage();
  }

  public boolean validateAddToCatPage() {
    return Action.isDisplayed(driver, dataSheet);
  }

  public int getQuantity() throws InterruptedException {
    Thread.sleep(3000);
    String productQuantity = quantity.getText();
    System.out.println("Product quantity : " + productQuantity);
    return Integer.parseInt(productQuantity);
  }

  public double getShippingCost() {
    String shippingCost = shippingPrice.getText().substring(1);
    System.out.println("shipping cost : " + shippingCost);
    return Double.parseDouble(shippingCost);
  }

  public double getTotalPrice() {
    String totalPrice = totalProductPrice.getText().substring(1);
    System.out.println("Total price : " + totalPrice);
    return Double.parseDouble(totalPrice);
  }

  public void selectingSize(String selectSize) {
    // Use 'L'
    Action.selectByVisibleText(selectSize, size);
  }
}
