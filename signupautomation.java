package testproject;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class signupautomation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/mercuryregister.php?osCsid=f1719dfb1e1911dee56f22fdeaf8805c";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAutomationsignuptestcase() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("REGISTER")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("akif");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("hazarvi");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("03446256500");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("akifhazarvi@yahoo.com");
    driver.findElement(By.name("address1")).clear();
    driver.findElement(By.name("address1")).sendKeys("xyz");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("abc");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("abc");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("abc");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("44000");
    new Select(driver.findElement(By.name("country"))).selectByVisibleText("PAKISTAN");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("akif");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Ptcl@123");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("Ptcl@123");
    driver.findElement(By.name("register")).click();
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
  }
}
