package model;

import java.util.HashMap;

public class RaceDto {
    private HashMap<String, String> carNameToAdvanceMap;
    private int attemptTimes;

    RaceDto(HashMap<String, String> carNameToAdvanceMap, int attemptTimes){
        this.carNameToAdvanceMap = carNameToAdvanceMap;
        this.attemptTimes = attemptTimes;
    }

    public HashMap<String, String> getCarNameToAdvanceMap(){
        return carNameToAdvanceMap;
    }

    public int getAttemptTimes(){
        return attemptTimes;
    }
}