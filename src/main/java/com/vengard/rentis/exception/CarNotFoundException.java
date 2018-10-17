package com.vengard.rentis.exception;

public class CarNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "Car with that id doesn't exist!";
    }
}
