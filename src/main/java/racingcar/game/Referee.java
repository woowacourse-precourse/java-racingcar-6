package racingcar.game;

import racingcar.car.Car;
import racingcar.numberGenerator.NumberGenerator;

import java.util.*;


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
            String key = car.getCarName();
            String value = getRaceScoreMapValue(car);
            raceScore.put(key, value);
            System.out.println(key + " : " + value);
        }
    }

    private String getRaceScoreMapValue(Car car) {
        String key = car.getCarName();
        String value = raceScore.get(key);
        if (value==null) {
            value = "";
        }
        value += car.goStep();
        return value;
    }


    public String determineWinner() {
        String topScore = Collections.max(raceScore.values());

        List<String> winner = new ArrayList<>();
        for (String key : raceScore.keySet()) {
            if (raceScore.get(key).equals(topScore)) {
                winner.add(key);
            }
        }

        return String.join(",", winner);
    }

}