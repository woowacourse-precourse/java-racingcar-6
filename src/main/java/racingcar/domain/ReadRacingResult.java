package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReadRacingResult {

    public void readHashMap(LinkedHashMap<String, Integer> racingResult) {

        for (Map.Entry<String, Integer> racingRecord : racingResult.entrySet()) {
            System.out.println(racingRecord.getKey() + " : " + "-".repeat(racingRecord.getValue()));
        }
        System.out.println();

    }

    public void judgmentWinner(LinkedHashMap<String, Integer> racingResult) {

        for (Map.Entry<String, Integer> racingRecord : racingResult.entrySet()) {

        }
    }

    public String findWinner(int maxRecord, Map.Entry<String, Integer> currentCarRecord) {

        if (currentCarRecord.getValue() >= maxRecord) {
            return currentCarRecord.getKey();
        }
        return null;
    }


}
