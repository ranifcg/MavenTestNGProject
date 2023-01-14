package testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class MultiBrowser {
	static WebDriver driver;
	

  @Test
  public void f() {
		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("raniselen");
		driver.findElement(By.id("password")).sendKeys("adactin");
		driver.findElement(By.cssSelector("input#login")).click();
  }
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) {
	  if (browser.equalsIgnoreCase("edge"))
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		  driver = new EdgeDriver();
	  }
	  else if(browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  driver.get("http://adactinhotelapp.com");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
