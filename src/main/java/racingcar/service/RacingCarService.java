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
    private final RandomNumUtil randomNumUtil = new RandomNumUtil();

    public Cars generateCars(String carNames) {
        List<String> carsInfos = ConverterUtil.covertStringToList(carNames);
        HashMap<String, String> initialGameStatus = new HashMap<>();
        cars = new Cars(carsInfos, initialGameStatus);
        cars.initCarsStatus();
        return cars;
    }

    public int generateRandomNum() {
        return randomNumUtil.generateRandomNum();
    }

    private boolean judgeMove(int randomNum) {
        boolean moving = false;
        if (randomNum >= MIN_FORWARD_NUMBER) {
            moving = true;
            return moving;
        }
        return moving;
    }

    public HashMap<String, String> judgeResult(HashMap<String, String> carsStatus) {

        for (String car : carsStatus.keySet()) {
            int randomNum = generateRandomNum();
            if (judgeMove(randomNum)) {
                carsStatus.put(car, carsStatus.get(car) + MOVE_FORWARD_STRING);
            }
        }
        return carsStatus;
    }

    private int mostMovementCount(HashMap<String, String> finalResult) {
        int maxLen = Integer.MIN_VALUE;
        for (String car : finalResult.keySet()) {
            maxLen = Math.max(maxLen, finalResult.get(car).length());
        }
        return maxLen;
    }

    public List<String> judgeWinners(HashMap<String, String> finalResult) {
        List<String> winners = new ArrayList<>();
        int mostMovementCount = mostMovementCount(finalResult);
        for (String car : finalResult.keySet()) {
            if (mostMovementCount == finalResult.get(car).length()) {
                winners.add(car);
            }
        }
        return winners;
    }

}
