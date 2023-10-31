package utils;

import java.util.Arrays;

public class Utils {
    final static String NOT_NUMBER = "시도 횟수는 0 이상의 정수이어야 합니다.";
    final static String NEGATIVE_NUMBER = "시도 횟수는 음수가 될 수 없습니다.";

    public String[] splitByDelimiter(String carNames) {
        return carNames.split(",");
    }

    public int convertStringToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        return Integer.parseInt(input);
    }

    public void isPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }


}
