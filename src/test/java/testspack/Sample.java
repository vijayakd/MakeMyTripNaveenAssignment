package testspack;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sample {
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

//public String monAsStr;
	public static void main(String[] args)   {

		Date formatteddate = null;
		Date date= new Date();
String formatdate=sdf.format(date);

System.out.println("Todays date===="+formatdate);
LocalDate localDate = LocalDate.now();
String todaysdate= DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate);
System.out.println("todaysdate======"+todaysdate);
String dateString[]=todaysdate.split("/");
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
	
	int newday=newRetrnDay-30;
	 System.out.println("new return date==*************==in new month==========="+newday);

	
int intnewmonth=intmonresult+1;
	System.out.println("new month result afetr adding 1 to current month======="+intnewmonth);
	String monAsStr=Integer.toString(intnewmonth);
	System.out.println("new month  as string======="+monAsStr);
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	}

}
