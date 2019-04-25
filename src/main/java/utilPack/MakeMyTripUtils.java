package utilPack;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basepack.MakeMyTripBasePage;

public class MakeMyTripUtils extends MakeMyTripBasePage{
	
	public static int page_load_timeout=20; 
	public static int implicit_wait_timeout=20;
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	
	public static String todaysDate() {
		Date formatteddate = null;
								Date date= new Date();
						String formatdate=sdf.format(date);
				
			System.out.println("Todays date===="+formatdate);
			 LocalDate localDate = LocalDate.now();
			String todaysdate= DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate);
			System.out.println("todaysdate==from =====utils===="+todaysdate);
		      /*  String dateString[]=todaysdate.split("/");
		       String dayval=dateString[0];
		        String monval=dateString[1];
		        String yearval=dateString[2];

		        System.out.println("dayval===="+dayval);
		        System.out.println("monval===="+monval);
		        System.out.println("yearval===="+yearval);
*/

		        return todaysdate;
			

	}
	public void takescreenshot() {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\vijay\\eclipse-workspace\\MakeMytripNaveenAssignment4April2019\\screenShots"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
