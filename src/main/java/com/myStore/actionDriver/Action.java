package com.myStore.actionDriver;

import com.myStore.base.BaseClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends BaseClass {

  public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", ele);
  }

  public void click(WebDriver driver, WebElement ele) {
    Actions act = new Actions(driver);
    act.moveToElement(ele).click().build().perform();
  }

  public boolean findElement(WebDriver driver, WebElement ele) {
    boolean flag = false;
    try {
      ele.isDisplayed();
      flag = true;
    } catch (Exception e) {
      flag = false;
    } finally {
      if (flag) {
        System.out.println("Successfully Found element at ");
      } else {
        System.out.println("Unable to locate element at ");
      }
    }
    return flag;
  }

  public boolean isDisplay(WebDriver driver, WebElement ele) {
    boolean flag = false;
    flag = findElement(driver, ele);
    if (flag) {
      flag = ele.isDisplayed();
      if (flag) {
        System.out.println("The element is displayed");
      } else {
        System.out.println("The element is not displayed");
      }
    } else {
      System.out.println("Not displayed ");
    }
    return flag;
  }

  public boolean isSelected(WebDriver driver, WebElement ele) {
    boolean flag = false;
    flag = findElement(driver, ele);
    if (flag) {
      flag = ele.isSelected();
      if (flag) {
        System.out.println("The element is selected");
      } else {
        System.out.println("The element is not selected");
      }
    } else {
      System.out.println("Not selected ");
    }
    return flag;
  }

  public boolean isEnable(WebDriver driver, WebElement ele) {
    boolean flag = false;
    flag = findElement(driver, ele);
    if (flag) {
      flag = ele.isEnabled();
      if (flag) {
        System.out.println("The element is enabled");
      } else {
        System.out.println("The element is not enabled");
      }
    } else {
      System.out.println("Not enabled ");
    }
    return flag;
  }

  /* Wait */
  public static void implicitWait(WebDriver driver, int timeOut) {
    driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
  }

  public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
    driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
  }
}
