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

        ExceptionController.carNameMaxLengthException(userCarNameArr);

        for (String car : userCarNameArr) {
            createUserCar.put(car, "");
        }

        ExceptionController.carNameDuplicateException(createUserCar, userCarNameArr);

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
