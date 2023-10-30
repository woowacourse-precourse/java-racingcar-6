package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import racingcar.Constant;

public class RacingGameController {

    public static void referee(HashMap<String, String> userCarName) {
        for (String key : userCarName.keySet()) {
            String value = userCarName.get(key);
            if (randomNumber() >= 4) {
                userCarName.put(key, value + "-");
            }
        }
    }

    public static String[] commaBasedSplitCarName(String carName) {
        String[] carNameArr = carName.split(Constant.COMMA);

        ExceptionController.carNameMaxLengthException(carNameArr);

        return carNameArr;
    }

    public static HashMap<String, String> makePersonalCarAndForwardStatus(final String[] carNameArr) {
        HashMap<String, String> createUserCar = new HashMap<>();

        for (String car : carNameArr) {
            createUserCar.put(car, "");
        }

        return createUserCar;
    }

    public static HashMap<String, String> carNameAndForwardStatus(final String carName) {
        String[] carNameArr = commaBasedSplitCarName(carName);
        HashMap<String, String> personalCar = makePersonalCarAndForwardStatus(carNameArr);

        ExceptionController.carNameDuplicateException(personalCar, carNameArr);

        return personalCar;
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
