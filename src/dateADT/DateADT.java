package dateADT;

import java.util.Calendar;

/**
 * I had initially tried to get this program to work with Date but I continually ran into problems,
 * which I believe were due to Date being deprecated. I changed everything to Calendar instead and
 * managed to get everything working properly.
 */
public interface DateADT {
    /**
     * Constructs a calendar object using the input year, month, and day.
     *
     * @param year  The year number.
     * @param month The month number.
     * @param day   The day number.
     * @return      The constructed calendar object.
     */
    public Calendar constructDate(int year, int month, int day);

    /**
     * Compares two calendar objects.
     *
     * @param date1 The first calendar object to compare.
     * @param date2 The second calendar object to compare.
     * @return      A negative value if date1 is earlier than date2,
     *              0 if date1 is equal to date2,
     *              or a positive value if date1 is later than date2.
     */
    public int compareDates(Calendar date1, Calendar date2);

    /**
     * Renders the calendar object in ISO format (e.g., "yyyy-mm-dd").
     *
     * @param date  The calendar object to render.
     * @return      The string representation of the date in ISO format.
     */
    public String renderISOFormat(Calendar date);

    /**
     * Adjusts the calendar object by a given number of days.
     *
     * @param date      The calendar object to adjust.
     * @param numDays   The number of days to advance (positive) or retreat (negative) the date.
     * @return          The adjusted calendar object.
     */
    public Calendar adjustDateByDays(Calendar date, int numDays);

}
