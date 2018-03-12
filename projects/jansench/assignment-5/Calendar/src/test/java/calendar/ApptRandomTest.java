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
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.RandInt(random);
				int startMinute = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);;
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";

				int startHour2=ValuesGenerator.RandInt(random);
				int startMinute2=ValuesGenerator.RandInt(random);
				int startDay2=ValuesGenerator.RandInt(random);
				int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2=ValuesGenerator.RandInt(random);
				String title2 = "Text 2";
				String description2 = "This is a description";

				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title,  description);
				Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2,  description2);
				appt.setStartHour(appt2.getStartHour());
				appt.setStartDay(appt2.getStartDay());
				appt.setStartYear(appt2.getStartYear());
				appt.setStartMonth(appt2.getStartMonth());
				appt.setStartMinute(appt2.getStartMinute());
				appt.setTitle(appt2.getTitle());
				appt.setDescription(appt2.getDescription());

				if(!appt.getValid() || !appt2.getValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					if (methodName.equals("setTitle")){
						String newTitle = (String) ValuesGenerator.getString(random);
						appt.setTitle(newTitle);
					}
					else if (methodName.equals("setRecurrence")){
						int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						int recur = ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						assertEquals(recurIncrement, appt.getRecurIncrement());
						assertEquals(recurNumber, appt.getRecurNumber());
						assertEquals(recur, appt.getRecurBy());
					}
					int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear2,startMonth2-1);
					if(startHour2 < 0 || startHour2 > 23)
						assertFalse(appt.getValid());

					if(startMinute2 < 0 || startMinute2 > 59)
						assertFalse(appt.getValid());

					if(startDay2 < 1 || startDay2 > NumDaysInMonth)
						assertFalse(appt.getValid());

					if(startMonth2 < 1 || startMonth2 > 12)
						assertFalse(appt.getValid());

					if(startHour2 >= 0 && startHour2 <= 23){
						if(startMinute2 >= 0 && startMinute2 <= 59){
							if(startDay2 >= 1 && startDay2 <= NumDaysInMonth){
								if(startMonth2 >= 1 && startMonth2 <= 12){
									assertTrue(appt.getValid());
								}
							}
						}
					}

				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}

}