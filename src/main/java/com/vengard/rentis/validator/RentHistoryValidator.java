package com.vengard.rentis.validator;

import com.vengard.rentis.model.RentHistory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class RentHistoryValidator implements Validator{

    Timestamp date;

    @Override
    public boolean supports(Class<?> clazz) {
        return RentHistory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RentHistory rentHistory = (RentHistory) target;

//        ValidationUtils.rejectIfEmptyOrWhitespace();
    }

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
