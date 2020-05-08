package aqdam.jfood;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateAndCalendar {
    //Convert Calendar to Date
    public static Timestamp ConvertToDate(Calendar calendar) {
        return new Timestamp(calendar.getTime().getTime());
    }
}
