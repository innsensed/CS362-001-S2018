package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Calendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=50;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle", "setRecurrence","deleteAppt"};// The list of the of methods to be tested in the Appt class

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
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...DataHandlerTest");
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		try{ 
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				
				 int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 23);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				 int startDay = ValuesGenerator.getRandomIntBetween(random, 2, 28);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 2, 12);
				 int startYear = ValuesGenerator.getRandomIntBetween(random, 2, 2018);
				 String title = "Birthday Party";
				 String description = ValuesGenerator.getString(random);
				 String emailAddress = ValuesGenerator.getString(random);

				long randomseed2 = System.currentTimeMillis(); //10
				Random random2 = new Random(randomseed2);
				
				 int startHour2 = ValuesGenerator.getRandomIntBetween(random2, 12, 23);
				 int startMinute2 = ValuesGenerator.getRandomIntBetween(random2, 12, 59);
				 int startDay2 = ValuesGenerator.getRandomIntBetween(random2, 12, 28);
				 int startMonth2 = ValuesGenerator.getRandomIntBetween(random2, 2, 12);
				 int startYear2 = ValuesGenerator.getRandomIntBetween(random2, 2000, 2018);
				long randomseed3 = System.currentTimeMillis(); //10
				Random random3 = new Random(randomseed3);
				
				 int startHour3 = ValuesGenerator.getRandomIntBetween(random3, -100, 100);
				 int startMinute3 = ValuesGenerator.getRandomIntBetween(random3, -30, 30);
				 int startDay3 = ValuesGenerator.getRandomIntBetween(random3, -2, 2);
				 int startMonth3 = ValuesGenerator.getRandomIntBetween(random3, -2, 2);
				 int startYear3 = ValuesGenerator.getRandomIntBetween(random3, -2002, 2002);
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
		         Appt appt3 = new Appt(startHour2,
		                  startMinute2,
		                  startDay2,
		                  startMonth2,
		                  startYear2,
		                  title,
		                 description,
		                 emailAddress);
			Appt appt2 = new Appt(startHour3,
				startMinute3,
				startDay3,
				startMonth3,
				startYear3,
				title3,
				description3,
				emailAddress3);
			// Construct calendars
			GregorianCalendar calendar = new GregorianCalendar(startYear, startMonth, startDay);
			GregorianCalendar calendar2 = new GregorianCalendar(startYear2, startMonth2, startDay2);

			CalDay calday = new CalDay(calendar);

			boolean value = ValuesGenerator.getBoolean(0.5f, random);
			String rstring = ValuesGenerator.getString(random);
			DataHandler datahandler = new DataHandler();
			DataHandler datahandler2 = new DataHandler(rstring, value);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) { // NUM_TESTS is 100
			try{ 
					String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle = (String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						}
					  else if (methodName.equals("setRecurrence")){
						   int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur = DataHandlerRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber = DataHandlerRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						datahandler.saveAppt(appt3); // both valid appointments
						datahandler.saveAppt(appt);
						datahandler.getApptRange(calendar, calendar2);
						}
					else if (methodName.equals("deleteAppt")){
	
							appt2.setValid();
							appt.setValid();
							appt2.getValid();
							appt.getValid();

							datahandler2.saveAppt(appt2);
							datahandler2.deleteAppt(appt2);
							datahandler2.saveAppt(appt);
							datahandler2.deleteAppt(appt);
							datahandler2.deleteAppt(appt);
							
							datahandler.saveAppt(appt);
							datahandler.saveAppt(appt2);
							datahandler.deleteAppt(appt);
							datahandler.deleteAppt(appt2);
					}

				}
				catch(DateOutOfRangeException e){
			              System.out.println("DateOutOfRangeException" + e);
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime); //check time
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}	

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime); //check time
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 
		}catch(NullPointerException e){
			              System.out.println("NullPointerException" + e);
		}
		}
		 System.out.println("Done testing...DataHandlerTest");
	 }

}
