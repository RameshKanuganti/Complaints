package com.valuepack.complaints.complaints.util;

import org.joda.time.Days;

import java.sql.Timestamp;
import java.util.Date;

public class Helper {

    public static Timestamp currentTimeStamp() {
        return new Timestamp(new Date().getTime());
    }


    public static long compareTwoTimeStamps(java.sql.Timestamp createdDate) {

        long milliseconds1 = createdDate.getTime();
        long milliseconds2 = currentTimeStamp().getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
    }

}

