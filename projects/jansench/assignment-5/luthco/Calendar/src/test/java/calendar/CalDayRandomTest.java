package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
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

	public static int RandomIntBetween(Random random, int min, int max){
		int randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber ; // return the method name
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				Calendar now = Calendar.getInstance();
				int thisMonth = now.get(Calendar.MONTH)+1;
				int thisYear = now.get(Calendar.YEAR);
				int thisDay = now.get(Calendar.DAY_OF_MONTH);
				GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
				CalDay cal = new CalDay(today);
				int j = 0;

				for (int i = 0; i < NUM_TESTS; i++) {
					int startHour = ValuesGenerator.RandInt(random);
					int startMinute = ValuesGenerator.RandInt(random);
					int startDay = ValuesGenerator.RandInt(random);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear = ValuesGenerator.RandInt(random);
					String title = ValuesGenerator.getString(random);
					String description = ValuesGenerator.getString(random);
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title,  description);
					if(appt.getValid()){
						j++;
						cal.addAppt(appt);
					}
				}
				assertTrue(cal.getSizeAppts() == j);
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}



}