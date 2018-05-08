
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
	assertTrue(datahandler0.saveAppt(appt1));
	assertTrue(datahandler0.saveAppt(appt0));
	datahandler0.getApptRange(today0, tomorrow0);
	assertTrue(datahandler0.deleteAppt(appt1));
	assertTrue(datahandler0.save());
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
	assertTrue(datahandler2.saveAppt(appt2));
	datahandler2.getApptRange(calendar2, tomorrow2);
	}
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	DataHandler datahandler3 = new DataHandler();
	GregorianCalendar calendar3 = new GregorianCalendar(2000, 4, 20);
	GregorianCalendar tomorrow3 = new GregorianCalendar(2020, 4, 21);
	datahandler3.getApptRange(calendar3, tomorrow3);
         int[] recurDaysArr = null;
	Appt appt4 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt4.setRecurrence(recurDaysArr,1,2,1);
        assertEquals(2, appt4.getRecurIncrement());
	Appt appt5 = new Appt(25, 500, 200, 19, 0, "My Appointment", "I must go", "abc@hotmail.com");
	assertTrue(datahandler3.saveAppt(appt4));
	assertTrue(datahandler3.saveAppt(appt5));
	datahandler3.getApptRange(calendar3, tomorrow3);
	assertTrue(datahandler3.save());
	}
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	DataHandler datahandler99 = new DataHandler("Hello.xml", true); //"Hello", true
	assertTrue(datahandler99.save());
	GregorianCalendar calendar4 = new GregorianCalendar(2000, 4, 20);
	GregorianCalendar tomorrow4 = new GregorianCalendar(2020, 4, 21);
	datahandler99.getApptRange(calendar4, tomorrow4);
	int[] recurDaysArr5 = {2,3,4,5,6};
	Appt appt6 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt6.setRecurrence(recurDaysArr5, 0, 0, 0);
        assertEquals(0, appt6.getRecurIncrement());
	DataHandler datahandler98 = new DataHandler("Tee", false);
	assertTrue(datahandler99.save()); // 98
	String string0 = appt6.toString();
	}
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	DataHandler datahandler50 = new DataHandler();
	GregorianCalendar itstoday = new GregorianCalendar(2, 3, 4);
	GregorianCalendar itsfirstday = new GregorianCalendar(2015, 12, 10);
	GregorianCalendar itslastday = new GregorianCalendar(2018, 12, 10);
	LinkedList<Appt> appts = new LinkedList<Appt>();
	Appt appt = new Appt(15, 30, 11, 4, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	int[] recurDaysArray = new int[0];
	appt.setRecurrence(recurDaysArray, Appt.RECUR_BY_MONTHLY, 0, 1);
	
	appts.add(appt);

	datahandler50.getApptRange(itsfirstday, itslastday);
	GregorianCalendar obj = new GregorianCalendar();	
	CalDay cal = new CalDay(obj);
	cal.addAppt(appt);
	
	GregorianCalendar day1 = new GregorianCalendar();
	GregorianCalendar day2 = new GregorianCalendar(2000, 4, 20);
	
	datahandler50.getApptRange(day2, day1);
	}
	
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	DataHandler datahandler52 = new DataHandler();
	GregorianCalendar day8 = new GregorianCalendar(2015, 6, 4);
	GregorianCalendar day9 = new GregorianCalendar(2018, 7, 7);
	int[] recurDaysArray2 = {1,2,3,4,5,6,7,8,9,0};
	
	Appt appt98 = new Appt(1, 1, 3, 5, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt97 = new Appt(5, 14, 8, 4, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt96 = new Appt(1, 25, 6, 3, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt95 = new Appt(1, 25, 6, 0, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

	appt98.setRecurrence(recurDaysArray2, 0, 0, 0);
	appt97.setRecurrence(recurDaysArray2, 1, 10, 20);
	appt96.setRecurrence(recurDaysArray2, 3, 30, -1);
	LinkedList<Appt> appts2 = new LinkedList<Appt>();
	appts2.add(appt98);	
	appts2.add(appt97);
	appts2.add(appt96);
	try{
		datahandler52.deleteAppt(appt95);
		assertEquals(3, appts2.size());
		datahandler52.getApptRange(day8, day9);
		
	}
	catch(NullPointerException e){
	
	}
}
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	DataHandler datahandler53 = new DataHandler();
	GregorianCalendar day10 = new GregorianCalendar(2015, 6, 4);
	GregorianCalendar day11 = new GregorianCalendar(2018, 7, 7);
	int[] recurDaysArray3 = {1,2,3,4,5,6,7,8,9,0};
	
	Appt appt94 = new Appt(1, 1, 3, 5, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt93 = new Appt(5, 14, 8, 4, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt92 = new Appt(1, 25, 6, 3, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	Appt appt91 = new Appt(1, 25, 6, 0, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

	appt94.setRecurrence(recurDaysArray3, 2, 2, 100);
	appt93.setRecurrence(recurDaysArray3, 1, 1, 100);
	appt92.setRecurrence(recurDaysArray3, 3, 3, 100);
	LinkedList<Appt> apptList = new LinkedList<Appt>();
	apptList.add(appt94);	
	apptList.add(appt93);
	apptList.add(appt92);
	apptList.add(appt91);

	assertTrue(datahandler53.saveAppt(appt94));
	assertTrue(datahandler53.saveAppt(appt93));
	assertTrue(datahandler53.saveAppt(appt92));
	assertTrue(datahandler53.saveAppt(appt91));
	
	try{
		datahandler53.getApptRange(day10, day11);
		assertEquals(4, apptList.size());
//		assertNull(appts2);
		assertTrue(datahandler53.deleteAppt(appt94));
		datahandler53.getApptRange(day10, day11);
		assertTrue(datahandler53.deleteAppt(appt93));
		datahandler53.getApptRange(day10, day11);
		assertTrue(datahandler53.deleteAppt(appt92));
		datahandler53.getApptRange(day10, day11);
		assertTrue(datahandler53.deleteAppt(appt91));
		datahandler53.getApptRange(day10, day11);

	}
	catch(NullPointerException e){
	
	}
}
/*
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	DataHandler datahandler51 = new DataHandler();
	GregorianCalendar itstoday1 = new GregorianCalendar(2, 3, 4);
	GregorianCalendar itsfirstday1 = new GregorianCalendar(2017, 12, 10);
	GregorianCalendar itslastday1 = new GregorianCalendar(2018, 12, 10);
	LinkedList<Appt> appts1 = new LinkedList<Appt>();
	Appt appt99 = new Appt(15, 30, 11, 4, 2017, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	int[] recurDaysArray1 = new int[0];
	appt99.setRecurrence(recurDaysArray1, Appt.RECUR_BY_MONTHLY, 0, 1);
	
	appts1.add(appt99);

	datahandler51.getApptRange(itsfirstday1, itslastday1);
	GregorianCalendar obj1 = new GregorianCalendar();	
	CalDay cal1 = new CalDay(obj1);
	cal1.addAppt(appt99);
	
	GregorianCalendar day4 = new GregorianCalendar();
	GregorianCalendar day5 = new GregorianCalendar(2000, 4, 20);
	try{
		datahandler51.getApptRange(day4, day5);
	}
	catch(DateOutOfRangeException e){
	
	}
	}*/

}
