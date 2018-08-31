package com.vengard.rentis.RentHistory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class RentHistoryValidator {

    Timestamp date;

    public boolean isRentHistoryCorrect(RentHistory rentHistory) {
        setDateToDatePlusOneDate(date);
        return isDateFuture(rentHistory.getDateRent()) &&
                isDateFuture(rentHistory.getDateReturn()) &&
                isDateFirstFutureThan(rentHistory.getDateRent(), rentHistory.getDateReturn());
    }

    private void setDateToDatePlusOneDate(Timestamp date){
        date = new Timestamp(new Date().getTime());
//        date.setHours();
        date.setMinutes(59);
    }

    private boolean isDateFuture(Date date) {
        return date.after(date);
    }

    private boolean isDateFirstFutureThan(Date dateFirst, Date dateSecond) {
        return dateFirst.after(dateSecond);
    }
}
