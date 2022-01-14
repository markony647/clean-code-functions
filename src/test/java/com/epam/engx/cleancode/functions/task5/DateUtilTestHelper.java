package com.epam.engx.cleancode.functions.task5;

import java.util.Date;

public class DateUtilTestHelper {

    public static Date getDirectlyIncrementedDate(DateUtil dateUtil, Date date) {
        return dateUtil.convertToNextMidnight(date);
    }

    public static Date getInverseIncrementedDate(DateUtil dateUtil, Date date) {
        return dateUtil.convertToPreviousMidnight(date);
    }
}
