package racingcar.domain;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ReadRacingResult {

    public void readHashMap(LinkedHashMap<String, Integer> racingResult) {

        for (Map.Entry<String, Integer> racingRecord : racingResult.entrySet()) {
            System.out.println(racingRecord.getKey() + " : " + "-".repeat(racingRecord.getValue()));
        }
        System.out.println();

    }

    public List<String> winners = new ArrayList<>();

    public void judgmentWinner(LinkedHashMap<String, Integer> racingResult) {
        int maxRecord = Collections.max(racingResult.values());
        for (Map.Entry<String, Integer> racingRecord : racingResult.entrySet()) {
            findWinner(maxRecord, racingRecord);
        }
        System.out.printf("최종 우승자 : %s%n", String.join(", ", winners));
    }

    public void findWinner(int maxRecord, Map.Entry<String, Integer> currentCarRecord) {

        if (currentCarRecord.getValue() >= maxRecord) {
            winners.add(currentCarRecord.getKey());
        }
    }


}
