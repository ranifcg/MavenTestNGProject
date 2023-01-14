package testng_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NewTest {
	static WebDriver driver;

  @Test (priority = 1)
  public void openBrowser()  {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	  	driver = new EdgeDriver();
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
  }
  
  @Test (priority = 2)
  public void loginApp() {
	  WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("raniselen");
		driver.findElement(By.id("password")).sendKeys("adactin");
		driver.findElement(By.cssSelector("input#login")).click();
  }
  
  @Test (priority = 3)
  public void closeBrowser() {
		driver.close();
		
  }
  
}
