package racingcar.domain;

import java.util.HashMap;

public class RaceSimulator {

    public static HashMap<String, String> raceSimulation(HashMap<String, String> carNames) {
        HashMap<String, String> racingResult = new HashMap<>();

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
}
