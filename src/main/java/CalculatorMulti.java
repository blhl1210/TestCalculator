import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by linh on 03/11/2017.
 */
public class CalculatorMulti {
  static WebDriver driver;
  private static String url = "https://blhl1210.github.io/";

  public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    driver = new ChromeDriver();
    driver.navigate().to(url);
    driver.manage().window().maximize();
  }

  public static String display(String expression) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById(\"display\").value = '"+expression+"'");
    js.executeScript("calculate();");
    WebElement result = driver.findElement(By.id("display"));
    return result.getAttribute("value");
  }
}
