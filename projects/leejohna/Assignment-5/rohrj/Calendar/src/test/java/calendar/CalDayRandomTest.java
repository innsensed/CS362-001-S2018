package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Calendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...CalDayTest");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				
				 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
				 String title = ValuesGenerator.getString(random);
				 String description = ValuesGenerator.getString(random);
				 String emailAddress = "xyz@gmail.com";

				long randomseed2 = System.currentTimeMillis(); //10
				Random random2 = new Random(randomseed2);
				
				 int startHour2 = ValuesGenerator.getRandomIntBetween(random2, 0, 23);
				 int startMinute2 = ValuesGenerator.getRandomIntBetween(random2, 0, 59);
				 int startDay2 = ValuesGenerator.getRandomIntBetween(random2, 1, 28);
				 int startMonth2 = ValuesGenerator.getRandomIntBetween(random2, 1, 12);
				 int startYear2 = ValuesGenerator.getRandomIntBetween(random2, 1, 2018);
				 String title2 = "Birthday Party";
				 String description2 = "This is my birthday party.";
				 String emailAddress2 = "xyz@gmail.com";

				long randomseed3 = System.currentTimeMillis(); //10
				Random random3 = new Random(randomseed3);
				
				 int startHour3 = ValuesGenerator.getRandomIntBetween(random3, -100, -10);
				 int startMinute3 = ValuesGenerator.getRandomIntBetween(random3, -100, -10);
				 int startDay3 = ValuesGenerator.getRandomIntBetween(random3, -11, -10);
				 int startMonth3 = ValuesGenerator.getRandomIntBetween(random3, -11, -10);
				 int startYear3 = ValuesGenerator.getRandomIntBetween(random3, -11, -10);
				 String title3 = "Birthday Party";
				 String description3 = "This is my birthday party.";
				 String emailAddress3 = "xyz@gmail.com";
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute,
		                  startDay,
		                  startMonth,
		                  startYear,
		                  title,
		                 description,
		                 emailAddress);
			Appt appt2 = new Appt(startHour2,
					startMinute2,
					startDay2,
					startMonth2,
					startYear2,
					title2,
					description2,
					emailAddress2);
			Appt appt3 = new Appt(startHour3,
					startMinute3,
					startDay3,
					startMonth3,
					startYear3,
					title3,
					description3,
					emailAddress3);

					appt3.setValid();
			GregorianCalendar calendar = new GregorianCalendar(startYear, startMonth, startDay);
			GregorianCalendar calendar2 = new GregorianCalendar(startYear3, startMonth3, startDay3);
			CalDay calday = new CalDay(calendar);
			CalDay calday2 = new CalDay(calendar2);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) { // NUM_TESTS is 100
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle = (String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						calday.getDay();
						calday.getMonth();
						calday.getYear();
						calday.getFullInfomrationApp(calday);
						calday.getSizeAppts();
						calday.toString();
						calday.addAppt(appt);
						calday.addAppt(appt2);
						calday2.addAppt(appt3);
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur = CalDayRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber = CalDayRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						calday.getDay();
						calday.getMonth();
						calday.getYear();
						calday.getFullInfomrationApp(calday);
						calday.getSizeAppts();
						calday.toString();
						calday.addAppt(appt);
						calday.addAppt(appt2);
						calday.addAppt(appt3);
						}
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime); //check time
			        if((iteration%10000)==0 && iteration!=0 ) // print elapsed when number of iterations hit 10,000
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}
		catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...CalDayRandomTest");
	 }

}
