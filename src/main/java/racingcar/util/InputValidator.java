package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final String REGEX = "[1-9]+";
    private static final int NAME_LENGTH_CONDITION = 5;

    public static List<String> checkInputCarNameList(String carNameList) {
        List<String> carList = List.of(carNameList.split(","));
        for (var car : carList) {
            if (!isLengthCondition(car.length())) {
                throw new IllegalArgumentException();
            }
        }
        return carList;
    }

    public static int checkInputTryNumber(String inputNumber) {
        if(isNumber(inputNumber)) {
            return Integer.parseInt(inputNumber);
        }
        throw new IllegalArgumentException();
    }

    private static boolean isNumber(String inputNumber) {
        return inputNumber.matches(REGEX);
    }

    private static boolean isLengthCondition(int carNameLength) {
        return carNameLength <= NAME_LENGTH_CONDITION && carNameLength > 0;
    }

}
