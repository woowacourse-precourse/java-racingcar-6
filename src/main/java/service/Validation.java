package service;

import java.util.regex.Pattern;

public class Validation {
    public static final Pattern timesPattern = Pattern.compile("^[1-9][0-9]*$");
    public static void CarNames(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException();
        }
    }

    public static void Times(String times){
        if(!timesPattern.matcher(times).matches()){
            throw new IllegalArgumentException();
        }
    }
}
