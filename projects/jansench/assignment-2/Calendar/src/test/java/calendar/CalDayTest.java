package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

		/* tests to see if a new calendar is valid */
	 @Test
	  public void test01()  throws Throwable  {
	 	 CalDay cal = new CalDay();
	 	 assertFalse(cal.isValid());
	 }


	 	/* tests to see if a constructed calendar is valid */
		@Test
		public void test02()  throws Throwable  {
			Calendar now = Calendar.getInstance();
			int month = now.get(Calendar.MONTH)+1;
			int day = now.get(Calendar.DAY_OF_MONTH);
			int year = now.get(Calendar.MONTH);
			GregorianCalendar today = new GregorianCalendar(year,month,day);
			CalDay calendarDay = new CalDay(today);
			assertTrue(calendarDay.isValid());
		}


		/* tests adding appointments */
	@Test
	public void test03()  throws Throwable  {
		int month = 1;
		int day = 15;
		int year = 2018;
		GregorianCalendar today = new GregorianCalendar(year,month,day);
		CalDay calendarDay = new CalDay(today);
		assertTrue(calendarDay.isValid());
		/* this is our appointment */
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		/* ensure our appt is valid */
		assertTrue(appt.getValid());
		/* add an appointment to our calendar Day */
		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());
		calendarDay.toString();
		/* change our values a bit */
		appt.setStartHour(7);
		assertTrue(appt.getValid());
		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());
		/* change our values a bit */
		appt.setStartHour(23);
		assertTrue(appt.getValid());
		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());

		/* lets test how many appointments we have */
		assertEquals(3, calendarDay.getSizeAppts());

		/* lets test getDay */
		assertEquals(15, calendarDay.getDay());

		/* lets test getMonth */
		assertEquals(1, calendarDay.getMonth());

		/* lets test getYear */
		assertEquals(2018, calendarDay.getYear());

	}
//add more unit tests as you needed	
}
