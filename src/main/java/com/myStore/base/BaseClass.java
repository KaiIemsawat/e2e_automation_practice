package com.myStore.base;

import com.myStore.actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
  public static Properties prop;
  public static WebDriver driver;

  @BeforeTest
  public void loadingConfig() {
    try {
      prop = new Properties();
      System.out.println("super constructor invoked");
      FileInputStream ip =
          new FileInputStream(System.getProperty("user.dir") + "/configs/Config.properties");
      prop.load(ip);
      System.out.println("driver : " + driver);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void launchApp() {
    //      setup driver
    String browserName = prop.getProperty("browser");

    if (browserName.contains("Chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browserName.contains("FireFox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else if (browserName.contains("IE")) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    }

    //    setup time wait
    Action.implicitWait(driver, 10);
    Action.pageLoadTimeOut(driver, 30);

    //    get url
    driver.get(prop.getProperty("url"));
  }
}
