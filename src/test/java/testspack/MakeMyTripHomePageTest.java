package testspack;

import org.testng.annotations.Test;

import basepack.MakeMyTripBasePage;
import pagespack.MakeMytripHomePage;

import org.testng.annotations.BeforeMethod;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MakeMyTripHomePageTest extends MakeMyTripBasePage{
	MakeMytripHomePage homePage;
	 
	 public MakeMyTripHomePageTest() {
		 super();
	 }

	/*  @Test(priority=1)
  public void validatePageTitleTest() {
		  System.out.println("**************IN HOMEPAGE VALIDATION TEST***************");
	  System.out.println("Before validating");
	  
	String homepagetitle=  homePage.MakeMyTripPageTitle();	  
	  System.out.println("After validating");
	  System.out.println("Page Title ===="+homepagetitle);
Assert.assertEquals(homepagetitle, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday");
System.out.println("******************************************************************************");
  }
	  @Test(priority=2)
	  public void tripSelection() throws InterruptedException {
		  System.out.println("**************IN TRIP SELECTION TEST***************");

		 boolean result= homePage.selectroundtrip();
		 System.out.println("round trip selected ====="+result);
		 Assert.assertTrue(result);
		 System.out.println("******************************************************************************");
 
	  }
	  
*/	 @Test(priority=3)
	  public void citiesselection() throws InterruptedException  {
		  System.out.println("**************IN  FROM CITY SELECTION  TEST***************");

		  homePage.selectroundtrip();
		  homePage.selectfromcity();
		  homePage.selecttocity();
		  homePage.selectRetrnDate();
		  homePage.validateSearchbtn();
	  }
  
   @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Initialization method");

	  initialization();
	  System.out.println("After Initialization method");
	  System.out.println("***********************");
	  homePage=new MakeMytripHomePage();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Before closing");

	  driver.quit();
	  System.out.println("After closing");
	  System.out.println("******************************************************************************");

  }

}
