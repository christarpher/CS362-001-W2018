package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class TimeTableRandomTest {

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
				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);

				GregorianCalendar first = new GregorianCalendar(0,1,1);
				CalDay cal = new CalDay(first);
				LinkedList<Appt> deletedAppt = new LinkedList<Appt>();
				TimeTable table = new TimeTable();
				int startHour2 = ValuesGenerator.RandInt(random);
				int startMinute2 = ValuesGenerator.RandInt(random);
				int startDay2 = ValuesGenerator.RandInt(random);
				int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2 = ValuesGenerator.RandInt(random);
				String title2 = ValuesGenerator.getString(random);
				String description2 = ValuesGenerator.getString(random);
				Appt appt = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2,  description2);
				int numOfAppt = ValuesGenerator.getRandomIntBetween(random, 0, 500);

				int k = 1;
				for (k = 1; k < numOfAppt; k++) {
					if (k != 1){
						int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
						int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
						int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 100);
						String title = ValuesGenerator.getString(random);
						String description = ValuesGenerator.getString(random);
						appt.setStartHour(startHour);
						appt.setStartMinute(startMinute);
						appt.setStartDay(startDay);
						appt.setStartMonth(startMonth);
						appt.setStartYear(startYear);
						appt.setTitle(title);
						appt.setDescription(description);
						cal.addAppt(appt);
					} else {
						int j = ValuesGenerator.getRandomIntBetween(random, 0, 1);
						if(j == 0){
							table.deleteAppt(null, appt);
						} else {
							table.deleteAppt(cal.getAppts(), null);
						}
					}
				}
				assertTrue(deletedAppt.isEmpty());
				deletedAppt = table.deleteAppt(cal.getAppts(),appt);
				assertFalse(deletedAppt.isEmpty());
				appt.setStartHour(startHour2);
				appt.setStartMinute(startMinute2);
				appt.setStartDay(startDay2);
				appt.setStartMonth(startMonth2);
				appt.setStartYear(570);
				appt.setTitle(title2);
				appt.setDescription(description2);
				GregorianCalendar second = new GregorianCalendar(500,1,1);
				CalDay cal2 = new CalDay(second);
				LinkedList<CalDay> CalList = table.getApptRange(cal.getAppts(), first, second);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}



}