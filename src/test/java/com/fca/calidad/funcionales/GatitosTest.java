package com.fca.calidad.funcionales;


import java.time.Duration;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GatitosTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;
  /*
    @Before
    public void setUp() throws Exception {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      baseUrl = "https://www.google.com/";
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
      js = (JavascriptExecutor) driver;
    }
  
    @Test
    public void testGatitos() throws Exception {
      driver.get("https://www.google.com/");
      driver.findElement(By.id("APjFqb")).clear();
      driver.findElement(By.id("APjFqb")).sendKeys("gatitos wikipedia");
      driver.findElement(By.name("btnK")).click();
      driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/div/div/span/a/h3")).click();
      driver.get("https://es.wikipedia.org/wiki/Felis_silvestris_catus");
      //Warning: assertTextPresent may require manual changes
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*wikipedia[\\s\\S]*$"));
    }
  
    @After
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }
  
    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
  
    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }
  
    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }*/
    
    @Test
    public void firstTest() {
    	assertTrue(true);
    }
  }
  