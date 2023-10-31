package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final String ENGLISH_REGEX = "^[a-zA-Z]*$";
    private static final int NAME_MAX_LENGTH_CONDITION = 5;
    private static final int NAME_MIN_LENGTH_CONDITION = 0;

    public static List<String> checkInputCarNameList(String carNameList) {
        List<String> carList = List.of(carNameList.split(","));
        for (var car : carList) {
            if (!isLengthCondition(car.length()) || !isEnglish(car)) {
                throw new IllegalArgumentException("자동차 이름 입력 오류");
            }
        }
        return carList;
    }

    public static int checkInputTryNumber(String inputNumber) {
        if (isNumber(inputNumber)) {
            return Integer.parseInt(inputNumber);
        }
        throw new IllegalArgumentException("시도 횟수 입력 오류");
    }

    private static boolean isNumber(String inputNumber) {
        return inputNumber.matches(NUMBER_REGEX);
    }

    private static boolean isEnglish(String inputValue) {
        return inputValue.matches(ENGLISH_REGEX);
    }

    private static boolean isLengthCondition(int carNameLength) {
        return carNameLength <= NAME_MAX_LENGTH_CONDITION && carNameLength > NAME_MIN_LENGTH_CONDITION;
    }

}
