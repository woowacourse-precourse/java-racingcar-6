package racingcar.domain;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ReadRacingResult {

    public String readHashMap(LinkedHashMap<Map.Entry<Integer, String>, Integer> racingResult) {
        String result = "";
        for (Map.Entry<Map.Entry<Integer, String>, Integer> racingRecord : racingResult.entrySet()) {
            result = racingRecord.getKey().getValue() + " : " + "-".repeat(racingRecord.getValue());
            System.out.println(result);
        }
        System.out.println();

        return result;

    }

    public List<String> winners = new ArrayList<>();

    public String judgmentWinner(LinkedHashMap<Map.Entry<Integer, String>, Integer> racingResult) {
        int maxRecord = Collections.max(racingResult.values());
        for (Map.Entry<Map.Entry<Integer, String>, Integer> racingRecord : racingResult.entrySet()) {
            findWinner(maxRecord, racingRecord);
        }
        String result = String.format("최종 우승자 : %s", String.join(", ", winners));
        System.out.println(result);
        return result;
    }

    public void findWinner(int maxRecord, Map.Entry<Map.Entry<Integer, String>, Integer> currentCarRecord) {

        if (currentCarRecord.getValue() >= maxRecord) {
            winners.add(currentCarRecord.getKey().getValue());
        }
    }


}
