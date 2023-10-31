package racingcar.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Move {

    public void moveTheCar(LinkedHashMap<String, String> carList, List<Integer> randomNumberList) {
        int randomNumberListIndex = 0;
        for (Map.Entry<String, String> entry : carList.entrySet()) {
            if (randomNumberList.get(randomNumberListIndex) >= 4) {
                carList.put(entry.getKey(), entry.getValue() + "-");
            }
            randomNumberListIndex++;
        }
    }

    public void stopTheCar(LinkedHashMap<String, String> carList, List<Integer> randomNumberList) {
        int randomNumberListIndex = 0;
        for (Map.Entry<String, String> entry : carList.entrySet()) {
            if (randomNumberList.get(randomNumberListIndex) < 4) {
                carList.put(entry.getKey(), entry.getValue() + "-");
            }
            randomNumberListIndex++;
        }
    }
}
