package com.vengard.rentis.service.rentcalculator;

import com.vengard.rentis.model.UserRole;

public class RentCarCalculatorFabric {

    public RentCarCalculatorAbs createRentCarCalculator(UserRole userRole) {
        RentCarCalculatorAbs rentCarCalculator;
        if(userRole.getRole().equals("USER"))
             rentCarCalculator = new RentCarCalculatorNormal();
        else if(userRole.getRole().equals("COMPANY"))
            rentCarCalculator = new RentCarCalculatorForCompany();
        else
            rentCarCalculator = new RentCarCalculatorNormal();
        return rentCarCalculator;
    }

}
