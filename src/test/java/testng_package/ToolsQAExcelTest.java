package testng_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ToolsQAExcelTest {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\CT181LL\\eclipse-workspace\\MavenTestNGProject\\PersonalDataSource.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		//Horrible Spread Sheet Format
		
		//by default Sheet 0 - first sheet
		HSSFSheet sh = wb.getSheetAt(0);
		
		//anything with x..xlsx,docx start with H. HWPF for word,HPSF for ny MS Office
		//int rowcount = sh.getLastRowNum() - sh.getFirsttRowNum();
		int cellcount = sh.getRow(1).getLastCellNum();
		
		String values[] = new String[cellcount];
		String fname, lname, email, address, mobile;
		
		// to print as numbers, not as double
		//NumberFormat formatter = new DecimalFormat("0.00000000000");
		NumberFormat formatter = new DecimalFormat("0");
		
		fname = sh.getRow(1).getCell(0).getStringCellValue();
		lname = sh.getRow(1).getCell(1).getStringCellValue();
		email = sh.getRow(1).getCell(2).getStringCellValue();
		mobile = formatter.format(sh.getRow(1).getCell(3).getNumericCellValue());
		address = sh.getRow(1).getCell(4).getStringCellValue();
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	  	WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userNumber")).sendKeys(String.valueOf(mobile));
		driver.findElement(By.id("currentAddress")).sendKeys(address);



	}
	

}
