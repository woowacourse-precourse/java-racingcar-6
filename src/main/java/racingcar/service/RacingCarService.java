package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.print.DocFlavor.READER;
import racingcar.model.Cars;
import racingcar.util.ConverterUtil;
import racingcar.util.RandomNumUtil;

public class RacingCarService {
    private static final String FORWARD_MOVING = "-";
    private static Cars cars;

    private static HashMap<String, String> gameResult = new HashMap<>();

    public HashMap<String, String> getGameResult() {
        return gameResult;
    }

    public void createCars(String carNames) {
        List<String> carsInfos = ConverterUtil.covertStringToList(carNames);
        cars = new Cars(carsInfos);
        gameResult = cars.initCarsMap();
    }

    public boolean judgeMove(int randomNum) {
//        int num = RandomNumUtil.generateRandomNum();
        boolean moving = false;
        if (randomNum >= 4) {
            moving = true;
            return moving;
        }
        return moving;
    }

    public HashMap<String, String> judgeResult() {
        int randomNum = RandomNumUtil.generateRandomNum();

        for (String car : gameResult.keySet()) {
            if (judgeMove(randomNum)) {
                gameResult.put(car, gameResult.get(car) + FORWARD_MOVING);
            }
        }
        return gameResult;
    }

    public int mostMovementCount() {
        int maxLen = Integer.MIN_VALUE;
        for (String car : gameResult.keySet()) {
            if (maxLen < gameResult.get(car).length()) {
                maxLen = gameResult.get(car).length();
            }
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
