package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReadRacingResult {

    public void readHashMap(LinkedHashMap<String, Integer> racingResult) {

        for (Map.Entry<String, Integer> entry : racingResult.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();

    }


}
