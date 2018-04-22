
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	DataHandler datahandler0 = new DataHandler();
	GregorianCalendar calendar0 = new GregorianCalendar(2000, 4, 20);
	GregorianCalendar today0 = new GregorianCalendar(2020, 4, 20);
	GregorianCalendar tomorrow0 = new GregorianCalendar(2020, 4, 21);

	Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt1 = new Appt(18, 15, 9, 10, 2018, "My Appointment", "I must go", "abc@hotmail.com");
	datahandler0.saveAppt(appt1);
	datahandler0.saveAppt(appt0);
	datahandler0.getApptRange(today0, tomorrow0);
	datahandler0.deleteAppt(appt1);
	datahandler0.save();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler datahandler1 = new DataHandler();
	GregorianCalendar calendar1 = new GregorianCalendar(2000, 4, 20);
	GregorianCalendar tomorrow1 = new GregorianCalendar(2020, 4, 21);

	datahandler1.getApptRange(calendar1, tomorrow1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	DataHandler datahandler2 = new DataHandler();
	GregorianCalendar calendar2 = new GregorianCalendar(2000, 4, 20);
	GregorianCalendar tomorrow2 = new GregorianCalendar(2020, 4, 21);
	datahandler2.getApptRange(calendar2, tomorrow2);
         int[] recurDaysArr={2,3,4};
	Appt appt2 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt2.setRecurrence(recurDaysArr,1,1,1);
	Appt appt3 = new Appt(25, 500, 200, 19, 0, "My Appointment", "I must go", "abc@hotmail.com");
	assertTrue(datahandler2.saveAppt(appt3));
	datahandler2.saveAppt(appt2);
	datahandler2.getApptRange(calendar2, tomorrow2);
	}
}
