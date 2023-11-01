package model;

import java.util.HashMap;
import java.util.List;

public class RaceDto {
    private HashMap<String, String> carNameToAdvanceMap;
    private final int attemptTimes;
    private final List<String> carNameList;

    public RaceDto(HashMap<String, String> carNameToAdvanceMap, int attemptTimes){
        this.carNameToAdvanceMap = carNameToAdvanceMap;
        this.attemptTimes = attemptTimes;
        this.carNameList = getCarNameToAdvanceMap().keySet().stream().toList();
    }

    public HashMap<String, String> getCarNameToAdvanceMap(){
        return carNameToAdvanceMap;
    }

    public int getAttemptTimes(){
        return attemptTimes;
    }

    public List<String> getCarNameList(){
        return carNameList;
    }
}