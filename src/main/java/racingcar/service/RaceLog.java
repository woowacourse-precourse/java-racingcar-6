package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceLog {
    public RaceLog(){}

    //createEmptyRaceLog
    public HashMap<String,String> createEmptyRaceLog(ArrayList<String> carNameList){
        HashMap<String,String> raceLog = new HashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            raceLog.put(carNameList.get(i),"");
        }
        return raceLog;
    }


    // isCarAdvance
    public boolean isCarAdvance(int randomNumber){
        if(randomNumber >= 4) {
            return true;
        }
        return false;
    }

    // addEachCarsRaceLog
    public void addEachCarsRaceLog(int i, HashMap<String, String> raceLog,ArrayList<String> carNameList){
        String eachLog = raceLog.get(carNameList.get(i));
        raceLog.replace(carNameList.get(i), eachLog + "-");
    }

}
