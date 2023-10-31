package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class RacingCarsValidator {
    private static final String EMPTY_NAME_ERROR_MESSAGE = "이름으로 빈 문자열을 입력하여 오류가 발생하였습니다.";
    private static final String LONG_NAME_ERROR_MESSAGE = "5자 이하가 아닌 이름을 입력하여 오류가 발생하였습니다.";
    private static int MAX_LENGTH_OF_NAME = 5;

    public List<String> validateNames(final String names) {
        List<String> namesSplit = splitNames(names);

        if (hasEmptyName(names)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        } else if (hasLongName(namesSplit)) {
            throw new IllegalArgumentException(LONG_NAME_ERROR_MESSAGE);
        }
        return namesSplit;
    }

    private static List<String> splitNames(final String names) {
        return Arrays.asList(names.split(","));
    }

    private static boolean hasEmptyName(final String names) {
        if (names.isEmpty()) {
            return true;
        } else if (names.charAt(0) == ',') {
            return true;
        } else if (names.charAt(names.length() - 1) == ',') {
            return true;
        }

        for (int i = 1; i < names.length(); i++) {
            if (names.charAt(i - 1) == ',' && names.charAt(i) == ',') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLongName(final List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_LENGTH_OF_NAME) {
                return true;
            }
        }
        return false;
    }
}
