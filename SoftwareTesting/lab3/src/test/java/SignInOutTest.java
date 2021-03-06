// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SignInOutTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    if(SetUp.Platform == 0) {
      System.setProperty("webdriver.chrome.driver", SetUp.chrome);
      driver = new ChromeDriver();
    }else{
      System.setProperty("webdriver.gecko.driver", SetUp.firefox);
      driver = new FirefoxDriver();
    }

    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void signInOut() throws  InterruptedException{
    driver.get("https://www.wolframalpha.com/");
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//button[@id=\'menuOpener\']/span/span)[3]")).click();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//div[@id=\'wolfram-id\']/input")).click();
    driver.findElement(By.xpath("//div[@id=\'wolfram-id\']/input")).sendKeys("leson.tpc@gmail.com");
    driver.findElement(By.xpath("//div[@id=\'form-actions\']/button")).click();
    driver.findElement(By.xpath("//div[@id=\'pw\']/input")).sendKeys("12345678");
    driver.findElement(By.xpath("//div[@id=\'remember\']/label")).click();
    driver.findElement(By.xpath("//div[@id=\'remember\']/label/input")).click();
    driver.findElement(By.xpath("//div[@id=\'form-actions\']/button")).click();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'__next\']/div/div/div/section/section[4]/h2/a/span/span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    //check signed in
    assertThat(driver.findElement(By.xpath("(//button[@id=\'menuOpener\']/span)[3]")).getText(), is("leson.tpc@gmail.co..."));
    driver.findElement(By.cssSelector(".oCnM3:nth-child(3)")).click();
    driver.findElement(By.xpath("(//a[@id=\'menuOpener\'])[7]")).click();

    {
      By loadingImage = By.cssSelector("wolfram-spinner no-opacity active");
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
    }
    driver.findElement(By.xpath("//div[@id='user-actions']/div/a")).click();

   // driver.get("https://account.wolfram.com/logout");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    assertThat(driver.findElement(By.xpath("//div[@id='form-main']/h3")).getText(), is("Sign In"));

  }
}