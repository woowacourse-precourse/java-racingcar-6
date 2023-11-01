package model;

import java.util.HashMap;

public class RaceDto {
    private HashMap<String, Integer> cars;
    private int attemptTimes;

    RaceDto(HashMap<String, Integer> cars, int attemptTimes){
        this.cars = cars;
        this.attemptTimes = attemptTimes;
    }

    public HashMap<String, Integer> getCars(){
        return cars;
    }

    public int getAttemptTimes(){
        return attemptTimes;
    }
}