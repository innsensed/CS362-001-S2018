/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
//      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {

      Appt appt1 = new Appt(5, 5, 5, 5, 2018, "Kashasha", "Tikitikit", "abc@hotmail.com");
      String string1 = appt1.toString();
      assertEquals(2, appt1.getRecurBy());
      assertFalse(appt1.isRecurring());
//      assertEquals("\t5/5/2018 at 5:5am ,Kashasha, Tikitikit\n", string1);
      assertEquals(0, appt1.getRecurIncrement());
      assertEquals("abc@hotmail.com", appt1.getEmailAddress());
      appt1.setValid();

}
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Appt appt2 = new Appt(15, 60, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string2 = appt2.toString();
      assertEquals(2, appt2.getRecurBy());
      assertFalse(appt2.isRecurring());
//      assertEquals("\t12/9/2018 at 3:60pm ,Birthday Party, This is my birthday party\n", string2);
      assertEquals(0, appt2.getRecurIncrement());
      appt2.setValid();
  }
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Appt appt3 = new Appt(15, 59, 9, 12, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string3 = appt3.toString();
      assertEquals(2, appt3.getRecurBy());
      assertFalse(appt3.isRecurring());
//      assertEquals("\t12/9/0 at 3:59pm ,Birthday Party, This is my birthday party\n", string3);
      assertEquals(0, appt3.getRecurIncrement());
      appt3.setValid();
	appt3.getXmlElement();
  }
/*
@Test(timeout = 4000)
 public void test02()  throws Throwable  {
      Appt appt2 = new Appt(999, 999, 999, 999, 2018, "iambad", "veryverybad", "nono@yahoo.com");
      String string2 = appt2.toString();
      appt2.setValid();
      Appt appt3 = new Appt(1, 999, 999, 999, 2018, "iambad", "veryverybad", "nono@yahoo.com");
      String string3 = appt3.toString();
      appt3.setValid();
      Appt appt4 = new Appt(1, 1, 999, 999, 2018, "iambad", "veryverybad", "nono@yahoo.com");
      String string4 = appt4.toString();
      appt4.setValid();
      Appt appt5 = new Appt(1, 1, 1, 999, 2018, "iambad", "veryverybad", "nono@yahoo.com");
      String string5 = appt5.toString();
      appt5.setValid();
}
*/
}
