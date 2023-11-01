package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public String compare(List<String> cars, List<Integer> racingResult) {
        int maxGoCount = Collections.max(racingResult);
        List<Integer> maxGoCountIndexes = findAllIndexOf(maxGoCount, racingResult);

        List<String> winners = new ArrayList<>();
        for (int index : maxGoCountIndexes) {
            winners.add(cars.get(index));
        }
        return String.join(",", winners);
    }


    public List<Integer> findAllIndexOf(int maxValue, List<Integer> racingResult) {
        List<Integer> indexes = new ArrayList<>();
        for (int index = 0; index < racingResult.size(); index++) {
            int value = racingResult.get(index);
            if (value == maxValue) {
                indexes.add(index);
            }
        }
        return indexes;
    }
}
