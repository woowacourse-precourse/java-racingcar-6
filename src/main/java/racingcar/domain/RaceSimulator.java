package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceSimulator {

    public static LinkedHashMap<String, String> raceSimulation(LinkedHashMap<String, String> carNames) {
        LinkedHashMap<String, String> racingResult = new LinkedHashMap<>();

        for (String car : carNames.keySet()) {
            int randomNumber = NumberGenerator.generateRandomNumber();
            String value = carNames.get(car);

            if (randomNumber >= 4) {
                value = value + "-";
            }
            racingResult.put(car, value);
        }

        return racingResult;
    }

    public static void raceWinner(LinkedHashMap<String, String> carResults) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (String car : carResults.keySet()) {
            String result = carResults.get(car);
            int distance = result.length();

            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car);
            } else if (distance == maxDistance) {
                winners.add(car);
            }
        }

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

}
