package model;

import static model.Number.MAX_NAME_LENGTH;
import static model.Number.MAX_NUMBER;
import static model.Number.MIN_NUMBER;
import static view.ExceptionMessage.PLEASE_INPUT_NAME_IN_MAX_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class UtilityModel {
    public static String[] splitByComma(String input) {
        return input.split(",");
    }

    public static void isInValidNames(String[] names) {
        for (String name : names) {
            compareLengthToMaxLength(name);
        }
    }

    private static void compareLengthToMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH + PLEASE_INPUT_NAME_IN_MAX_LENGTH);
        }
    }

    public static int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}