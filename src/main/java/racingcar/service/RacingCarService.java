package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.model.Cars;
import racingcar.util.ConverterUtil;
import racingcar.util.RandomNumUtil;

public class RacingCarService {
    private static final String MOVE_FORWARD_STRING = "-";
    private static final int MIN_FORWARD_NUMBER = 4;
    private static Cars cars;

    private static HashMap<String, String> gameResult = new HashMap<>();

    public void generateCars(String carNames) {
        List<String> carsInfos = ConverterUtil.covertStringToList(carNames);
        cars = new Cars(carsInfos);
        gameResult = cars.initGameResult();
    }

    public int generateRandomNum() {
        return RandomNumUtil.generateRandomNum();
    }

    public boolean judgeMove(int randomNum) {
        boolean moving = false;
        if (randomNum >= MIN_FORWARD_NUMBER) {
            moving = true;
            return moving;
        }
        return moving;
    }

    public HashMap<String, String> judgeResult() {

        for (String car : gameResult.keySet()) {
            int randomNum = generateRandomNum();
            if (judgeMove(randomNum)) {
                gameResult.put(car, gameResult.get(car) + MOVE_FORWARD_STRING);
            }
        }
        return gameResult;
    }

    public int mostMovementCount() {
        int maxLen = Integer.MIN_VALUE;
        for (String car : gameResult.keySet()) {
            maxLen = Math.max(maxLen, gameResult.get(car).length());
        }
        return maxLen;
    }

    public List<String> judgeWinners() {
        List<String> winners = new ArrayList<>();
        int mostMovementCount = mostMovementCount();
        for (String car : gameResult.keySet()) {
            if (mostMovementCount == gameResult.get(car).length()) {
                winners.add(car);
            }
        }
        return winners;
    }

}
