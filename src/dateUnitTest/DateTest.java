package dateUnitTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dateADT.DevonDate;
import dateADT.DateADT;

public class DateTest {

	DevonDate one;
    DevonDate two;
    static DevonDate zero;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        zero = new DevonDate();
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        zero = null;
    }

    @Before
    public void setUp() throws Exception {
        one = new DevonDate();
        two = new DevonDate();
    }

    @After
    public void tearDown() throws Exception {
        one = null;
        two = null;
    }

	@Test
	public void testConstructDate() {
        DateADT dateADT = new DevonDate();
        Calendar date = dateADT.constructDate(2022, 10, 18);
        assertEquals(2022, date.get(Calendar.YEAR));
        assertEquals(10, date.get(Calendar.MONTH) + 1);
        assertEquals(18, date.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testCompareDates() {
        DateADT dateADT = new DevonDate();
        Calendar date1 = dateADT.constructDate(2022, 10, 18);
        Calendar date2 = dateADT.constructDate(2022, 10, 19);
        int result = dateADT.compareDates(date1, date2);
        assertTrue(result < 0); // date1 is earlier than date2
    }

    @Test
    public void testRenderISOFormat() {
        DateADT dateADT = new DevonDate();
        Calendar date = dateADT.constructDate(2022, 10, 18);
        String isoFormat = dateADT.renderISOFormat(date);
        assertEquals("2022-10-18", isoFormat);
    }

    @Test
    public void testAdjustDateByDaysPositive() {
        DateADT dateADT = new DevonDate();
        Calendar date = dateADT.constructDate(2022, 10, 18);
        Calendar adjustedDate = dateADT.adjustDateByDays(date, 5);
        assertEquals(2022, adjustedDate.get(Calendar.YEAR));
        assertEquals(10, adjustedDate.get(Calendar.MONTH) + 1);
        assertEquals(23, adjustedDate.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testAdjustDateByDaysNegative() {
        DateADT dateADT = new DevonDate();
        Calendar date = dateADT.constructDate(2022, 10, 18);
        Calendar adjustedDate = dateADT.adjustDateByDays(date, -3);
        assertEquals(2022, adjustedDate.get(Calendar.YEAR));
        assertEquals(10, adjustedDate.get(Calendar.MONTH) + 1);
        assertEquals(15, adjustedDate.get(Calendar.DAY_OF_MONTH));
    }

}
