/**
 * 
 */
package pagespack;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepack.MakeMyTripBasePage;
import utilPack.MakeMyTripUtils;


public class MakeMytripHomePage extends MakeMyTripBasePage {
	public String monAsStr;
	public String dayAsStr;
	//public 	String beforeXpath="//div[@class=\"DayPicker-Months\"]//div[@class=\"DayPicker-Day\"]//p[(text()=\"";
	
	public String afterXpath="\")]";

	public  int newday;
	public 
	// In this class we r storing objects in makemytriphomepage
		//we have to define pagefactory or object Repository . In page factory we use @FindBy to locate elements

	@FindBy(xpath="//ul[@class=\"fswTabs latoBlack greyText\"]//li[contains(text(),\"Round Trip\")]")
	WebElement roundTrip;

	@FindBy(xpath="//span[contains(text(),\"From\")]")
	WebElement fromcity;
	
	@FindBy(xpath="//input[@class=\"react-autosuggest__input react-autosuggest__input--open\" and @value=\"Delhi\"]")
	WebElement fromcity1;
	

	@FindBy(xpath="//span[contains(text(),\"To\")]")
	WebElement tocity;
	
	@FindBy(xpath="//p[contains(text(),\"Bangalore, India\")]")
	WebElement tocity1_bang;

	@FindBy(xpath="//span[contains(text(),\"DEPARTURE\")]")
	WebElement depart;
	
	@FindBy(xpath="DayPicker-Day DayPicker-Day--start DayPicker-Day--end DayPicker-Day--selected DayPicker-Day--today")
	WebElement depart_today;
	
	@FindBy(xpath="//span[contains(text(),\"RETURN\")]")
	WebElement retrn_sel;
	
	@FindBy(xpath="//div[@class=\"DayPicker-Months\"]//div[@class=\"DayPicker-Day\"]//p[(text()=\"2\")]")
	WebElement retrn_sel_newday;
	
	@FindBy(xpath="//a[@class=\"primaryBtn font24 latoBlack widgetSearchBtn \"]")
	WebElement search_btn;
	
	//Initializing these webelements
	
	
	public MakeMytripHomePage() {
		PageFactory.initElements(driver, this);
	}
	//**********************************************************************
	//ACTIONS ON THIS PAGE
	
	public String MakeMyTripPageTitle() {
		return driver.getTitle();
	}
	public boolean selectroundtrip() throws InterruptedException {
		 roundTrip.click();
		Thread.sleep(3000);
		 return true;
	}
	
	public void selectfromcity() {
		
		fromcity.click();
		driver.findElement(By.xpath("//p[contains(text(),\"Delhi, India\")]")).click();
		//from_city.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void selecttocity() {
		tocity.click();
		tocity1_bang.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void selectdepartdates( ) throws InterruptedException   {
System.out.println("***********IN SELECT DEPARTURE DATES METHOD****************");
		depart.click(); 
		Thread.sleep(3000);
		
		//depart_today.click();		

			
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", depart_today);
		
		}
*/	public void selectRetrnDate( ) throws InterruptedException {

	retrn_sel.click();
	Thread.sleep(3000);
String currentdate=MakeMyTripUtils.todaysDate();

System.out.println("currentdate========="+currentdate);
String dateString[]=currentdate.split("/");
String dayval=dateString[0];
 String monval=dateString[1];
 String yearval=dateString[2];

 System.out.println("dayval===="+dayval);
 System.out.println("monval===="+monval);
 System.out.println("yearval===="+yearval);

 int intdayresult=Integer.parseInt(dayval);
 System.out.println("new day  result afetr converting string to integer======="+intdayresult);

 int intmonresult=Integer.parseInt(monval);
 System.out.println("new month result afetr converting string to integer======="+intmonresult);


 int  newRetrnDay=intdayresult+7;
 System.out.println("new return date======="+newRetrnDay);
 
 if(newRetrnDay>30)
 {
 	//make new return month by adding 1
 	//and change new day
	  newday=newRetrnDay-30;
	 System.out.println("new return date====in new month==========="+newday);

	
 int intnewmonth=intmonresult+1;
 	System.out.println("new month result afetr adding 1 to current month======="+intnewmonth);
 	 monAsStr=Integer.toString(intnewmonth);
	System.out.println("new month  as string======="+monAsStr);

	 dayAsStr=Integer.toString(newday);
		System.out.println("new day  as string======="+dayAsStr);
	
		System.out.println("before clicking return date");
		retrn_sel_newday.click();
		Thread.sleep(3000);
		System.out.println("after clicking return date");

		//retrn_sel_newday.click();
 }else {
	 
	 System.out.println("new return date======="+newRetrnDay);
 }
 	
	System.out.println("new month  as string======="+monAsStr);
	System.out.println("new day  as string======="+dayAsStr);
 
}

public void validateSearchbtn() throws InterruptedException {
	System.out.println("BEFORE SEARCHING");
	search_btn.click();
	System.out.println("AFTER SEARCHING");

	Thread.sleep(3000);
//	driver.navigate().back();

}
}
