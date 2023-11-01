package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceLog {
    public RaceLog() {
    }

    // 2-1. 초기 레이싱 기록을 만든다 : createEmptyRaceLog
    public HashMap<String, String> createEmptyRaceLog(ArrayList<String> carNameList) {
        HashMap<String, String> raceLog = new HashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            raceLog.put(carNameList.get(i), "");
        }
        return raceLog;
    }


    // 2-3-1. 각 경주차의 전진 여부를 확인한다: isCarAdvance
    public boolean isCarAdvance(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    // 2-3-2. 전진 여부에 따라 각 경주차의 기록을 갱신한다: addEachCarsRaceLog
    public void addEachCarsRaceLog(int i, HashMap<String, String> raceLog, ArrayList<String> carNameList) {
        String eachLog = raceLog.get(carNameList.get(i));
        raceLog.replace(carNameList.get(i), eachLog + "-");
    }

}
