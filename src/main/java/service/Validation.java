package service;

public class Validation {
    public static void CarNames(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException();
        }
    }
}
