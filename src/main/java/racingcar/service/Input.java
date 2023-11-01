package racingcar.service;

import racingcar.exception.CheckException;

public class Input {

    public static String[] splitCarName(String notSplitCar) {

        String[] carName = notSplitCar.split(",");
        CheckException.checkSplitCarNameException(carName);

        return carName;
    }
    public static int assignChallengeNumber(String number) {
        int intNumber = CheckException.checkAssignChallengeNumber(number);

        return intNumber;
    }
}
