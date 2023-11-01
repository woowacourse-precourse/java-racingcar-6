package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Race {

    private final List<HashMap<String, Integer>> raceResult = new ArrayList<>();
    private final List<Car> participatedCars;
    private final int attemptNumber;

    public Race(List<Car> participatedCars, int attemptNumber) {
        this.participatedCars = participatedCars;
        this.attemptNumber = attemptNumber;
    }

    public List<HashMap<String, Integer>> getRaceResult() {
        for (int i = 0; i < attemptNumber; i++) {
            HashMap<String, Integer> raceResult = new HashMap<>();
            for (Car car : participatedCars) {
                car.move();
                raceResult.put(car.getName(), car.getPosition());
            }
            this.raceResult.add(raceResult);
        }
        return raceResult;
    }

    public static List<String> getWinners(List<HashMap<String, Integer>> raceResult) {
        List<String> winners = new ArrayList<>();

        HashMap<String, Integer> lastRaceResult = raceResult.get(raceResult.size() - 1);
        int maxScore = Integer.MIN_VALUE;
        Set<String> maxScoreKeys = lastRaceResult.keySet();

        for (String key : maxScoreKeys) {
            int value = lastRaceResult.get(key);

            if (value > maxScore) {
                maxScore = value;
                winners.clear();
                winners.add(key);
            } else if (value == maxScore) {
                winners.add(key);
            }
        }

        return winners;
    }
}
