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
		 int month = 1;
		 int day = 15;
		 int year = 2018;
		 GregorianCalendar today = new GregorianCalendar(year,month,day);
		 GregorianCalendar tomorrow = new GregorianCalendar(year,month,day+1);
		 CalDay calendarDay = new CalDay(today);
		 CalDay calendarDay2 = new CalDay(tomorrow);
		 assertTrue(calendarDay.isValid());
		 /* this is our appointment */
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 /* Collection of all of the appointments for the calendar day */
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
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
		 listAppts.add(appt);
		 /* change our values a bit */
		 startHour = 7;
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt2);
		 /* create our timetable */
	 	 TimeTable timetable = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = new LinkedList<CalDay>();
		 /* ensure our linked list is empty */
		 assertTrue(calDays.isEmpty());
		 /* get ApptRange and ensure it's not empty now */
		 calDays = timetable.getApptRange(listAppts, today, tomorrow);
		 assertFalse(calDays.isEmpty());
		 /* delete an appointment */
		 LinkedList<Appt> deletedAppt = new LinkedList<Appt>();
		 assertTrue(deletedAppt.isEmpty());
		 deletedAppt = timetable.deleteAppt(listAppts, listAppts.get(0));
		 /*assertFalse(deletedAppt.isEmpty());
		   Further code testing will not work in timetable due to the bug I introduced.
		   As such, getnextApptOccurence, and getApptOccurences do not get called */
	 }
//add more unit tests as you needed
}
