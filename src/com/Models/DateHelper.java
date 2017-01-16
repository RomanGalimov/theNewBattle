package com.Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {
    private Calendar calendar;
    private int skippedTime = 0;

    DateHelper() {
        calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -1500);
    }

    String getFormattedStartDate() {
        return "Дата: " + calendar.get(Calendar.DAY_OF_MONTH) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR)
                + "\nВремя: " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
    }

    void skipTime() {
        calendar.add(Calendar.MINUTE, 45);
        skippedTime+=45;
    }

    String getFormattedDiff() {
        String diff = "Сражение длилось ";
        int days = 0;
        int hours = 0;
        while (skippedTime >= 1440) {
            days++;
            skippedTime-=1440;
        }
        while (skippedTime >= 60) {
            hours++;
            skippedTime-=60;
        }
        if (days > 0) {
            if (days == 1) {
                diff += "1 день ";
            } else {
                diff += (days + " дня(ей) ");
            }
        }
        if (hours > 0) {
            if (hours == 1) {
                diff += "1 час ";
            } else {
                diff += (hours + " часа(ов) ");
            }
        }
        if (skippedTime > 0) {
            diff += "и " + skippedTime + " минут";
        }
        return diff;
    }

}
