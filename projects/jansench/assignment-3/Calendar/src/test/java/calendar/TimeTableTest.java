package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void test01()  throws Throwable  {
		/* this is our appointment */
		int startHour=13;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		int[] recurrances = new int[] {1,2,3};
		/* make our calendars */
		GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
		GregorianCalendar tomorrow = new GregorianCalendar(startYear,startMonth,startDay+1);
		/* make our appts */
		Appt appt1 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		Appt appt2 = new Appt(startHour+2,startMinute,startDay,startMonth,startYear,title+"!",description);
		Appt appt3 = new Appt(startHour+3,startMinute,startDay,startMonth,startYear,title+"?",description);
		Appt appt4 = new Appt(startHour+4,startMinute,startDay,startMonth,startYear,title+"!?",description);
		appt3.setRecurrence(recurrances, 1,2,0);
		appt4.setRecurrence(recurrances, 2, 1, 0);
		assertTrue(appt1.getValid());
		assertTrue(appt2.getValid());
		assertTrue(appt3.getValid());
		assertTrue(appt4.getValid());
		/* Collection of all of the appointments for the calendar day */
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		/* add to our calendar */
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);
		/* make our timetable */
		TimeTable timetable = new TimeTable();
		timetable.getApptRange(listAppts, today, tomorrow);
	}


	/* let's try deleting appts */
	@Test
	public void test02()  throws Throwable  {
		/* this is our appointment */
		int startHour=13;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		int[] recurrances = new int[] {1,2,3};
		/* make our calendars */
		GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
		GregorianCalendar tomorrow = new GregorianCalendar(startYear,startMonth,startDay+1);
		/* make our appts */
		Appt appt1 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		Appt appt2 = new Appt(startHour+2,startMinute,startDay,startMonth,startYear,title+"!",description);
		Appt appt3 = new Appt(startHour+3,startMinute,startDay,startMonth,startYear,title+"?",description);
		Appt appt4 = new Appt(startHour+4,startMinute,startDay,startMonth,startYear,title+"!?",description);
		appt3.setRecurrence(recurrances, 1,2,0);
		appt4.setRecurrence(recurrances, 2, 1, 0);
		assertTrue(appt1.getValid());
		assertTrue(appt2.getValid());
		assertTrue(appt3.getValid());
		assertTrue(appt4.getValid());
		/* Collection of all of the appointments for the calendar day */
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts3 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts4 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts5 = new LinkedList<Appt>();
		TimeTable timetable = new TimeTable();
		/* should be null */
		listAppts2 = timetable.deleteAppt(listAppts, null);
		assertEquals(null, listAppts2);
		/* add to our calendar */
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);
		/* should also be null */
		listAppts3 = timetable.deleteAppt(listAppts, null);
		assertEquals(null, listAppts3);
		/* should also be null */
		listAppts4 = timetable.deleteAppt(listAppts2, appt2);
		assertEquals(null, listAppts4);
		/* should be 4 appts in timetable */
		assertTrue(listAppts.size() == 4);
		/* this should be successful */
		listAppts5 = timetable.deleteAppt(listAppts, appt2);
		assertFalse(listAppts5.isEmpty());
		/* should be 3 appts in timetable */
		assertTrue(listAppts.size() == 3);
		/* lets try to make an invalid one */
		Appt appt5 = new Appt(startHour+4,startMinute,startDay,startMonth,startYear,title+"!?",description);
		appt5.setStartHour(24);
		listAppts.add(appt5);
		assertTrue(timetable.deleteAppt(listAppts, appt5) == null);
	}


	/* let's try permute */
	@Test
	public void test03()  throws Throwable {
		/* this is our appointment */
		int startHour = 13;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		int[] recurrances = new int[]{1, 2, 3};
		/* make our calendars */
		GregorianCalendar today = new GregorianCalendar(startYear, startMonth, startDay);
		GregorianCalendar tomorrow = new GregorianCalendar(startYear, startMonth, startDay + 1);
		/* make our appts */
		Appt appt1 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		Appt appt2 = new Appt(startHour+2,startMinute,startDay,startMonth,startYear,title+"!",description);
		Appt appt3 = new Appt(startHour+3,startMinute,startDay,startMonth,startYear,title+"?",description);
		Appt appt4 = new Appt(startHour+4,startMinute,startDay,startMonth,startYear,title+"!?",description);
		appt3.setRecurrence(recurrances, 1,2,0);
		appt4.setRecurrence(recurrances, 2, 1, 0);
		assertTrue(appt1.getValid());
		assertTrue(appt2.getValid());
		assertTrue(appt3.getValid());
		assertTrue(appt4.getValid());
		/* Collection of all of the appointments for the calendar day */
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);
		assertFalse(listAppts.isEmpty());
		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		assertTrue(listAppts2.isEmpty());

		TimeTable timetable = new TimeTable();
		int[] intArray = new int[]{2,0,1,3};
		listAppts2 = timetable.permute(listAppts, intArray);
		assertFalse(listAppts2.isEmpty());

	}
//add more unit tests as you needed
}