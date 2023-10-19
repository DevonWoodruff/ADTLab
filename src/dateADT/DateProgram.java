/**
 * 
 */
package dateADT;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 */
public class DateProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the day of the week: ");
        String dayName = scanner.nextLine();
        scanner.close();

        DateADT dateADT = new DevonDate();

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= getLastDayOfMonth(2010, month); day++) {
                Calendar date = dateADT.constructDate(2010, month, day);
                String actualDayName = getDayName(date.get(Calendar.DAY_OF_WEEK));

                if (dayName.equalsIgnoreCase(actualDayName)) {
                    String formattedDate = dateADT.renderISOFormat(date);
                    System.out.println(formattedDate);
                }
            }
        }
    }

    private static int getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // Note: Calendar months are zero-based
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static String getDayName(int dayOfWeek) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[dayOfWeek - 1];
    }
}
