package day3;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public Date getCurrentDate() {
        return new Date();
    }

    public Date tomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurrentDate());
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
}