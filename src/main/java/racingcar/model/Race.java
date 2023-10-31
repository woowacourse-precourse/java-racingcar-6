package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        int maxPosition = 0;
        for (HashMap<String, Integer> result : raceResult) {
            for (String carName : result.keySet()) {
                if (result.get(carName) > maxPosition) {
                    maxPosition = result.get(carName);
                    winners.clear();
                    winners.add(carName);
                } else if (result.get(carName) == maxPosition) {
                    winners.add(carName);
                }
            }
        }
        return winners;
    }
}
