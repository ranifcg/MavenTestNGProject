package testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsTest {
	
  @Test (priority = 1)
  public void af2() {
	  System.out.println("in af2");
	  Reporter.log("in af2");

  }
  @Test (priority = 2)
  public void F1() {
	  System.out.println("in F1");
	  Reporter.log("in F1");


  }
  @Test (priority = 3)
  public void F() {
	  System.out.println("in F");
	  Reporter.log("in F");


  }
  @Test (enabled = false)
  public void BF() {
	  System.out.println("in BF");
	  Reporter.log("in BF");


  }
  
//-1,0,1,2 .. priority order
//no priority priority 0, same priority = alphabetical order
  //enabled = false for skipping

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("in BeforeMethod");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("in AfterMethod");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("in BeforeClass");
	  

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("in AfterClass");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("in BeforeTest");

  }
  

  @AfterTest
  public void afterTest() {
	  System.out.println("in AfterTest");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("in BeforeSuite");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("in AfterSuite");

  }

}
