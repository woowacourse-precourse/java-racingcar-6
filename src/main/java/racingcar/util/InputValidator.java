package racingcar.util;

public class InputValidator {
    private static final String REGEX = "[1-9]+";
    private static final int NAME_LENGTH_CONDITION = 5;

    public static boolean checkInputCarName(String carNameList) {
        String[] carList = carNameList.split(",");
        for (var car : carList) {
            if (isLengthOverThanLengthCondition(car.length())) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static boolean checkInputTryNumber(int inputNumber) {
        return isNumber(inputNumber);
    }

    private static boolean isNumber(int inputNumber) {
        return String.valueOf(inputNumber).matches(REGEX);
    }

    private static boolean isLengthOverThanLengthCondition(int carNameLength) {
        return carNameLength > NAME_LENGTH_CONDITION;
    }
}
