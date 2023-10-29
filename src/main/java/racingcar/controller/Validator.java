package racingcar.controller;

import java.util.List;
import racingcar.constant.GameMessage;

public class Validator {
    public static void isRightName(List<String> carName) {
        for (String name : carName) {
            isUnderFiveCharacterOrLess(name);
        }
    }

    public static void isUnderFiveCharacterOrLess(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(GameMessage.ERROR_OVER_FIVE_CHARACTER);
        }
    }

    public static void isINumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameMessage.ERROR_NOT_INT_COUNT);
        }
    }

    public static boolean isFourOrMore(Integer randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
