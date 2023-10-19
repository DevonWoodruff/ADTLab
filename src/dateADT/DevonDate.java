/**
 * 
 */
package dateADT;

import java.util.Calendar;

/**
 * Calendar dates are 0 based so 1 is subtracted or added to match the input.
 */
public class DevonDate implements DateADT {
	

	@Override
	public Calendar constructDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar;
	}

	@Override
	public int compareDates(Calendar date1, Calendar date2) {
        return date1.compareTo(date2);
    }

	@Override
	public String renderISOFormat(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) + 1;
        int day = date.get(Calendar.DAY_OF_MONTH);
        return String.format("%04d-%02d-%02d", year, month, day);
    }

	@Override
	public Calendar adjustDateByDays(Calendar date, int numDays) {
        Calendar adjustedDate = (Calendar) date.clone();
        adjustedDate.add(Calendar.DAY_OF_MONTH, numDays);
        return adjustedDate;
    }

}
