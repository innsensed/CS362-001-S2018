/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
        CalDay calDays0 = new CalDay();
	String strong0 = calDays0.toString();
	assertEquals(0, calDays0.getDay());
	assertEquals(0, calDays0.getMonth());
	assertEquals(0, calDays0.getYear());
	calDays0.getAppts();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler datahandler = new DataHandler();
	GregorianCalendar calendar = new GregorianCalendar(2020, 4, 20);
	CalDay calDays1 = new CalDay(calendar);
	Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	calDays1.addAppt(appt0);
	calDays1.getFullInfomrationApp(calDays1);
	assertEquals(1, calDays1.getSizeAppts());
	String string1 = calDays1.toString();
  }

}
