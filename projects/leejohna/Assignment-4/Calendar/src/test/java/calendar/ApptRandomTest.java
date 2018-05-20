package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence","isOn"};// The list of the of methods to be tested in the Appt class

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
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...ApptRandomTest");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				
				 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
				 String title = "Birthday Party";
				 String description = ValuesGenerator.getString(random);
				 String emailAddress = ValuesGenerator.getString(random);


				long randomseed2 = System.currentTimeMillis(); //10
				Random random2 = new Random(randomseed2);
				
				 int startHour2 = ValuesGenerator.getRandomIntBetween(random2, -100, 100);
				 int startMinute2 = ValuesGenerator.getRandomIntBetween(random2, -100, 100);
				 int startDay2 = ValuesGenerator.getRandomIntBetween(random2, -100, 100);
				 int startMonth2 = ValuesGenerator.getRandomIntBetween(random2, -100, 100);
				 int startYear2 = ValuesGenerator.getRandomIntBetween(random2, -2018, 2018);
				 String title2 = "Birthday Party";
				 String description2 = "This is my birthday party.";
				 String emailAddress2 = "xyz@gmail.com";
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute,
		                  startDay,
		                  startMonth,
		                  startYear,
		                  title,
		                 description,
		                 emailAddress);

				appt.setValid();

			Appt appt2 = new Appt(startHour2,
					startMinute2,
					startDay2,
					startMonth2,
					startYear2,
					title2,
					description2,
					emailAddress2);

				appt2.setValid();
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) { // NUM_TESTS is 100
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle = (String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						appt.getRecurIncrement();
						appt.toString();
						appt.isRecurring();
						appt.getEmailAddress();
						appt.getXmlElement();
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur = ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						   appt.setRecurrence(null, recur, recurIncrement, recurNumber);
						appt.setValid();
						appt2.setValid();
						appt.getRecurIncrement();
						appt.toString();
						appt.isRecurring();
						appt.getEmailAddress();
						appt.getXmlElement();
						}
					else if (methodName.equals("isOn")){
						appt.isOn(startDay, startMonth, startYear);
						appt.isOn(1, 1, 1);
						appt2.isOn(startDay, startMonth, startYear);
					}
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime); //check time
			        if((iteration%10000)==0 && iteration!=0 ) // print elapsed when number of iterations hit 10,000
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}
		catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...ApptRandomTest");
	 }

}
