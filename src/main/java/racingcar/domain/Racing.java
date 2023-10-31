package racingcar.domain;

import java.util.HashMap;

public class Racing {
    private static HashMap<String, Integer> carDistances = new HashMap<>();

    public static void racingResult(HashMap<String, Integer> distances, int number) {
        if (number > 3) {
            for (String car : distances.keySet()) {
                int currentDistance = distances.get(car);
                distances.put(car, currentDistance + 1);
            }
        }
    }
}
