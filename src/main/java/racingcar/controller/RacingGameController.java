package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import racingcar.Constant;

public class RacingGameController {

    public static Map<String, Integer> makePersonalCarAndForwardStatus(List<String> carNames) {
        Map<String, Integer> carMoveStatus = new HashMap<>();

        for (String car : carNames) {
            carMoveStatus.put(car, 0);
        }
        return carMoveStatus;
    }

    public static Map<String, Integer> carNameAndForwardStatus(List<String> carNames) {
        Map<String, Integer> personalCar = makePersonalCarAndForwardStatus(carNames);

        ExceptionController.carNameDuplicateException(personalCar, carNames);

        return personalCar;
    }

    public static List<String> mostMoveForwardCar(Map<String,Integer> carMoveStatus) {
        List<String> winners = new ArrayList<>();
        int max = Collections.max(carMoveStatus.values());

        for (String winner : carMoveStatus.keySet()) {
            if (carMoveStatus.get(winner) == max) {
                winners.add(winner);
            }
        }

        return winners;
    }

    public static void moveForward(Map<String, Integer> userCars) {
        for (String key : userCars.keySet()) {
            moveCondition(userCars, key, randomNumber());
        }
    }

    public static void moveCondition(Map<String, Integer> userCars, String key, int value) {
        if (value >= Constant.FORWARD_STANDARD) {
            userCars.put(key, userCars.get(key) + 1);
        }
    }

    private static int randomNumber() {
        return pickNumberInRange(Constant.MIN_RANDOM_NUMBER_RANGE, Constant.MAX_RANDOM_NUMBER_RANGE);
    }
}
