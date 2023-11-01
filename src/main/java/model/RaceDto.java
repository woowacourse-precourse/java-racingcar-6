package model;

import java.util.HashMap;

public class RaceDto {
    private HashMap<String, String> cars;
    private int attemptTimes;

    RaceDto(HashMap<String, String> cars, int attemptTimes){
        this.cars = cars;
        this.attemptTimes = attemptTimes;
    }

    public HashMap<String, String> getCars(){
        return cars;
    }

    public int getAttemptTimes(){
        return attemptTimes;
    }
}