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

  public static void click(WebDriver driver, WebElement ele) {
    Actions act = new Actions(driver);
    act.moveToElement(ele).click().build().perform();
  }

  public static boolean findElement(WebDriver driver, WebElement ele) {
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

  public static boolean isDisplay(WebDriver driver, WebElement ele) {
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

  public static boolean isSelected(WebDriver driver, WebElement ele) {
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

  public static boolean isEnable(WebDriver driver, WebElement ele) {
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

  /* Type / send key*/
  public static boolean type(WebElement ele, String s) {
    boolean flag = false;
    try {
      flag = ele.isDisplayed();
      ele.clear();
      ele.sendKeys(s);
      flag = true;
    } catch (Exception e) {
      System.out.println("Location not found");
      flag = false;
    } finally {
      if (flag) {
        System.out.println("Successfully entered value");
      } else {
        System.out.println("Unable to enter valus");
      }
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

  /* Metadata */
  public static String getTitle(WebDriver driver) {
    String title = driver.getTitle();
    System.out.println("The title of this page is : " + title);
    return title;
  }
}
