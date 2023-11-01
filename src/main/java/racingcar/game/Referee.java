package racingcar.game;

import racingcar.car.Car;
import racingcar.numberGenerator.NumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final Map<String, String> raceScore = new HashMap<>();


    NumberGenerator numberGenerator = new NumberGenerator();

    public Boolean isMovingCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }

    public void runRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            collectSteps(cars);
            System.out.println();
        }
    }

    public void collectSteps(List<Car> cars) {
        for (Car car : cars) {
            String key = getRaceScoreMapKey(car);
            String value = getRaceScoreMapValue(car);
            updateRaceProgress(key, value);
            System.out.println(key + " : " + value);
        }
    }

    private String getRaceScoreMapKey(Car car) {
        return car.getCarName();
    }

    private String getRaceScoreMapValue(Car car) {
        String key = getRaceScoreMapKey(car);
        String value = raceScore.get(key) + car.goStep();
        if (isCarRaceScoreValueNull(key)) {
            value = car.goStep();
        }
        return value;
    }

    private void updateRaceProgress(String key, String value) {
        raceScore.put(key, value);
    }

    private boolean isCarRaceScoreValueNull(String key) {
        return raceScore.get(key) == null;
    }
}
