package racingcar.exception;

import java.util.Arrays;
import java.util.List;

public class InputCheck {
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;

    private static final String NO_INPUT = "값을 입력해 주세요";
    private static final String NOT_INPUT_CAR_NAME_BETWEEN_1TO5 = "1자 이상 5자 이하의 자동차 이름을 입력해주세요";
    private static final String NOT_TRY_NUM = "숫자를 입력해 주세요";

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
    public static List<String> checkCarNames(String names) {
        names = names.replace(" ", "");
        isExist(names);
        List<String> carNames = toList(names);
        AllNamesMoreThanFive(carNames);
        return carNames;
    }

    private static void isExist(String checkValue) {
        if (checkValue.isEmpty()) {
            throwException(NO_INPUT);
        }
    }

    private static void AllNamesMoreThanFive(List<String> carNames) {
        for (String name : carNames) {
            isMoreThanFive(name.length());
        }
    }

    public static Integer checkTryNum(String tryNum) {
        isExist(tryNum);
        return toNumber(tryNum);
    }



    private static List<String> toList(String names) {
        return Arrays.asList(names.split(","));
    }



    private static boolean checkBetween1to5(int checkSize) {
        return MIN_NAME_SIZE <= checkSize && checkSize < MAX_NAME_SIZE;
    }

    private static void isMoreThanFive(int checkSize) {
        if (!checkBetween1to5(checkSize)) {
            throwException(NOT_INPUT_CAR_NAME_BETWEEN_1TO5);
        }
    }

    private static Integer toNumber(String tryNum) {
        try {
            return Integer.parseInt(tryNum);
        } catch (NumberFormatException numberFormatException) {
            throwException(NOT_TRY_NUM);
        }

        return null;
    }
}
