package racingcar.game;

import racingcar.car.Car;
import racingcar.numberGenerator.NumberGenerator;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class Referee {

    private static final int MOVE_CONDITION_NUMBER = 4;

    private final Map<String, String> raceScore = new HashMap<>();
    NumberGenerator numberGenerator = new NumberGenerator();

    public Boolean isMovingCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= MOVE_CONDITION_NUMBER;
    }

    // for test
    public Boolean isMovingCondition(int randomNumber) {
        return randomNumber >= MOVE_CONDITION_NUMBER;
    }

    // 시도 횟수만큼 실행
    public void runRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            collectSteps(cars);
            System.out.println();
        }
    }

    public void collectSteps(List<Car> cars) {
        for (Car car : cars) {
            String key = car.getCarName();
            String value = getRaceScoreMapValue(car, key);
            raceScore.put(key, value);
            System.out.println(key + " : " + value);
        }
    }

    private String getRaceScoreMapValue(Car car, String key) {
        String value = raceScore.get(key);
        if (value == null) {
            value = "";
        }
        value += car.goStep();
        return value;
    }

    // 경기 결과(최종 우승자) 도출
    public String determineWinner() {
        String topScore = Collections.max(raceScore.values());
        List<String> winner = new ArrayList<>();

        for (String key : raceScore.keySet()) {
            findWinners(key, topScore, winner);
        }
        return String.join(",", winner);
    }

    public void findWinners(String key, String topScore, List<String> winner) {
        if (raceScore.get(key).equals(topScore)) {
            winner.add(key);
        }
    }


}