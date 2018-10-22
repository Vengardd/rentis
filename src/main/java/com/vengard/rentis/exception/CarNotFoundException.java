package com.vengard.rentis.exception;

public class CarNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Car with that id doesn't exist!";
    }
}
