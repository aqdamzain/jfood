package aqdam.jfood;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Provide the conversion between
 * Calendar type dan Timestamp
 */
public class DateAndCalendar {
    /**
     * Method is used to convert Calendar data type to
     * TimeStamp data type
     * @param calendar is a gregorian calendar
     */
    public static Timestamp ConvertToDate(Calendar calendar) {
        return new Timestamp(calendar.getTime().getTime());
    }
}
