package service;

import java.util.regex.Pattern;

public class Validation {
    private static final int MAX_NAME_SIZE = 5;
    private static final Pattern timesPattern = Pattern.compile("^[1-9][0-9]*$");
    public static void CarNames(String carName){
        if(carName.length()>MAX_NAME_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static void Times(String times){
        if(!timesPattern.matcher(times).matches()){
            throw new IllegalArgumentException();
        }
    }
}
