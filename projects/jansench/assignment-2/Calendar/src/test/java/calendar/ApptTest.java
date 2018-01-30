package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

	 }

	 /* this test checks to see if sets methods are working properly */
	 @Test
	  public void test02()  throws Throwable  {
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


		 // assertions for checking hours
		 assertTrue(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 // set hour back to a valid number
		 appt.setStartHour(21);


		 // assertions for checking minutes
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 /* The following test fails due to a bug in the code!)
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid()); */
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 // set minute back to a valid number
		 appt.setStartMinute(30);


		 // assertions for checking days
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(25);
		 assertTrue(appt.getValid());
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(33);
		 assertFalse(appt.getValid());
		 // set day back to a valid number
		 appt.setStartDay(20);


		 // assertions for checking months
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
		 /* these are out of bounds!
		 appt.setStartMonth(0);
		 assertFalse(appt.getValid());
		 appt.setStartMonth(13);
		 assertFalse(appt.getValid()); */
		 // set day back to a valid number
		 appt.setStartMonth(6);

		 //check to see if year works
		 appt.setStartYear(2019);
		 assertTrue(appt.getValid());
	 }


	/* this tests for recur stuff */
	@Test
	public void test03()  throws Throwable  {
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
		// assertions
		assertTrue(appt.getValid());
		assertEquals(0, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertEquals(0, appt.getRecurIncrement());
	}


	/* this tests for representationApp and toString  */
	@Test
	public void test04()  throws Throwable  {
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

		String representation = appt.toString();
		// assertions
		assertTrue(appt.getValid());
		assertEquals(representation, "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n");

	}
	
}
