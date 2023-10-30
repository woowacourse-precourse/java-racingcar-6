package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RacingGameController {

    public static void referee(HashMap<String, String> userCarName) {
        for (String key : userCarName.keySet()) {
            String value = userCarName.get(key);
            if (randomNumber() >= 4) {
                userCarName.put(key, value + "-");
            }
        }
    }

    public static HashMap<String, String> userCarNameSave(final String inputCarName) {
        HashMap<String, String> createUserCar = new HashMap<>();
        String[] userCarNameArr = inputCarName.split(",");
        for (String userCars : userCarNameArr) {
            if (userCars.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
        for (String car : userCarNameArr) {
            createUserCar.put(car, "");
        }
        return createUserCar;
    }

    public static List<String> mostMovingForwardCar(HashMap<String,String> carMoveStatus) {
        List<String> winnerList = new ArrayList<>();
        String mostForward = Collections.max(carMoveStatus.values());

        for (String winner : carMoveStatus.keySet()) {
            if (mostForward.equals(carMoveStatus.get(winner))) {
                winnerList.add(winner);
            }
        }
        return winnerList;
    }

    public static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
