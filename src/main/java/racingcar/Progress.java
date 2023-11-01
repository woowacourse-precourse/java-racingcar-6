package racingcar;

import java.util.Map;

public class Progress {
    public static void takeProgress(Map<String, Integer> status) {
        for (Map.Entry<String, Integer> entry : status.entrySet()) {
            entry.setValue(entry.getValue() + Random.getRandom());
        }
    }
}
