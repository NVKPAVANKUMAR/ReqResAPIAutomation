package org.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Represents the common helper to fulfill the framework related task.
 * Such as encode, decode, get current date and time, read property file, etc.
 *
 * @author NVK PAVANKUMAR
 * @version 1.0
 */
public class CommonHelper {

    protected static Properties properties;

    public static String encode(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    public static String decode(String string) {
        return new String(Base64.getDecoder().decode(string));
    }

    /**
     * Get current date and time on specific format.
     *
     * @return time -> It returns time in specific format.
     * @author NVK PAVANKUMAR
     */
    public static String getCurrentDateTimeFormate() {
        // Get the specific date format
        DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        String time = "" + dateFormat.format(cal.getTime());
        return time;
    }

    /**
     * This method gives the current date and time on specific format.
     *
     * @return It returns time in specific format.
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_hh_mm_ss");
        return formatter.format(new Date());
    }

    /**
     * Get current date.
     *
     * @return It returns current date.
     * @author NVK PAVANKUMAR
     */
    public static String getCurrentDate() {
        return getCurrentDateTimeFormate().substring(0, 11);
    }


}
