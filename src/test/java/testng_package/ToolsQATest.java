package testng_package;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolsQATest {
	static WebDriver driver;

	  @Test
	  public void f() {
//			create an instance of Actions class
				driver.findElement(By.id("userName")).sendKeys("Rani R Nair");
				driver.findElement(By.id("userEmail")).sendKeys("Rani.R.Nair@gds.ey.com");
				
				//<textarea placeholder="Current Address" rows="5" cols="20" id="currentAddress" class="form-control"></textarea>
				WebElement c_add = driver.findElement(By.id("currentAddress"));
				c_add.sendKeys("#B204, Aradhana Residency");
				String curr_add = c_add.getText();
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

				//<textarea rows="5" cols="20" id="permanentAddress" class="form-control"></textarea>
				WebElement p_add = driver.findElement(By.id("permanentAddress"));
				actions.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				
				String perm_add = p_add.getText();

				assertEquals(curr_add, perm_add);
	  }
	  @BeforeTest
	  public void beforeTest() {
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		  	driver = new EdgeDriver();
			driver.get("https://demoqa.com/text-box");
			driver.manage().window().maximize();
			
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
}
