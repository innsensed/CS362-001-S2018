/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {

      Appt appt1 = new Appt(0, 5, 5, 5, 2018, "Kashasha", "Tikitikit", "abc@hotmail.com");
      String string1 = appt1.toString();
      assertEquals(2, appt1.getRecurBy());
      assertFalse(appt1.isRecurring());
      assertEquals(0, appt1.getRecurIncrement());
      assertEquals("abc@hotmail.com", appt1.getEmailAddress());
      appt1.setValid();
	assertEquals(0, appt1.getStartHour());

}
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Appt appt2 = new Appt(10, 59, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string2 = appt2.toString();
      assertEquals(2, appt2.getRecurBy());
      assertFalse(appt2.isRecurring());
      assertEquals(0, appt2.getRecurIncrement());
      appt2.setValid();
	assertEquals(10, appt2.getStartHour());
  }
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Appt appt3 = new Appt(16, 59, 9, 12, 1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string3 = appt3.toString();
      assertEquals(2, appt3.getRecurBy());
      assertFalse(appt3.isRecurring());
      assertEquals(0, appt3.getRecurIncrement());
     appt3.setValid();
	assertTrue(appt3.getValid());
	assertEquals(null, appt3.getXmlElement());
	assertTrue(appt3.isOn(9,12,1));
	assertTrue(appt3.hasTimeSet());
	assertEquals(12, appt3.getStartMonth());
	assertEquals(9, appt3.getStartDay());
	appt3.setDescription("hi");
	assertEquals("hi", appt3.getDescription());
	assertEquals(16, appt3.getStartHour());
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Appt appt4 = new Appt(16, 59, 9, 0, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt4.setValid();
      Appt appt7 = new Appt(16, 59, 9, 13, 1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt7.setValid();
	assertEquals(13, appt7.getStartMonth());
	}
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Appt appt5 = new Appt(23, 59, 1, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt5.setValid();
	assertTrue(appt5.getValid());

      Appt appt6 = new Appt(0, 0, 1, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt6.setValid();
	assertTrue(appt6.getValid());
	}
}
