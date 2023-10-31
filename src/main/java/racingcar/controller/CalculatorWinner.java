package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorWinner {
    public static String winner(Map<String, Integer> racingCar) {
        int maxValue = Integer.MIN_VALUE;
        List<String> winnerName = new ArrayList<>();

        for (int value : racingCar.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        for (Map.Entry<String, Integer> entry : racingCar.entrySet()) {
            if (entry.getValue() == maxValue) {
                winnerName.add(entry.getKey());
            }
        }

        String result = String.join(", ", winnerName);
        return result;
    }
}
