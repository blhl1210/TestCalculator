import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by linh on 03/11/2017.
 */
public class CalculatorTest {
  static WebDriver driver;
  private static String url = "https://blhl1210.github.io/";

  //Setup Driver
  @BeforeClass
  public static void setupTest() {

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

    driver = new ChromeDriver();
    driver.navigate().to(url);
    driver.manage().window().maximize();
  }
  @Test
  public void calculatorJavaScriptTest() {
    JavascriptExecutor js =(JavascriptExecutor)driver;
    for (int i = 0;i<2;i++) {
      js.executeScript("document.getElementById(\"display\").value = '3+2'");
      js.executeScript("calculate();");
      WebElement result = driver.findElement(By.id("display"));
      //5-) Assert that result is 12
      try {
        assertThat(result.getAttribute("value"), is("6"));
      }catch (AssertionError assertionError){
          assertionError.printStackTrace();
      }
    }
  }

  //Close Driver
  @AfterClass
  public static void quitDriver() {
    driver.quit();
  }
}