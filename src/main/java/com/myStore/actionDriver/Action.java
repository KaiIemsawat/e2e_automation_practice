package com.myStore.actionDriver;

import com.myStore.base.BaseClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action extends BaseClass {

  public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", ele);
  }

  public static void click(WebDriver driver, WebElement ele) {
    Actions act = new Actions(driver);
    System.out.println(ele.getText());
    act.moveToElement(ele).click().build().perform();
  }

  public static boolean jsClick(WebDriver driver, WebElement ele) {
    boolean flag = false;
    try {
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].click();", ele);
      flag = true;
    } catch (Exception e) {
      throw e;
    } finally {
      if (flag) System.out.println("Click Action is performed");
      else System.out.println("Clink Action is not perform ");
    }
    return flag;
  }

  public static boolean findElement(WebDriver driver, WebElement ele) {
    boolean flag = false;
    try {
      ele.isDisplayed();
      flag = true;
    } catch (Exception e) {
      // System.out.println("Location not found: "+locatorName);
      flag = false;
    } finally {
      if (flag) {
        System.out.println("Successfully Found element at");

      } else {
        System.out.println("Unable to locate element at");
      }
    }
    return flag;
  }

  public static boolean isDisplayed(WebDriver driver, WebElement ele) {
    boolean flag = false;
    flag = findElement(driver, ele);
    if (flag) {
      flag = ele.isDisplayed();
      if (flag) {
        System.out.println("The element is Displayed");
      } else {
        System.out.println("The element is not Displayed");
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
      if (flag = ele.isDisplayed()) {
        System.out.println("Found element..");
      }
      ele.clear();
      System.out.println("clearing text...");
      ele.sendKeys(s);
      System.out.println("Sending text.....");
      flag = true;
    } catch (Exception e) {
      System.out.println("Location not found" + e.getMessage());
      flag = false;
    } finally {
      if (flag) {
        System.out.println("Successfully entered value");
      } else {
        System.out.println("Unable to enter values");
      }
    }
    return flag;
  }

  /* Select */
  public static boolean selectByVisibleText(String visibleText, WebElement ele) {
    boolean flag = false;
    try {
      Select s = new Select(ele);
      s.selectByVisibleText(visibleText);
      flag = true;
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    } finally {
      if (flag) {
        System.out.println("Option selected bt VisibleText");
      } else {
        System.out.println("Option is not selected");
      }
    }
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
