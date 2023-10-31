package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String NUMBER_REG = "^[0-9]*$";

    private InputHandler() {
    }

    public static List<String> parseInputToList(String input) throws IllegalArgumentException {
        List<String> parsedList;
        
        parsedList = splitInputByComma(input);
        if (!validateCarNameLength(parsedList)) {
            throw new IllegalArgumentException("잘못된 입력 값입니다 자동차 이름을 5자리 이하로 입력해주세요.");
        }
        return parsedList;
    }

    public static int parseInputToIntager(String input) throws IllegalArgumentException {
        int parsedInt = 0;

        if (!isNumber(input)) {
            throw new IllegalArgumentException("잘못된 입력 값입니다. 숫자를 입력해주세요.");
        }
        parsedInt = Integer.parseInt(input);

        if (isPositiveInteger(parsedInt)) {
            throw new IllegalArgumentException("잘못된 입력 값입니다. 자연수를 입력해주세요.");
        }
        return parsedInt;
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static boolean validateCarNameLength(List<String> carNames) {
        int endInclusive = 5;
        for (String carName : carNames) {
            if (carName.length() <= endInclusive) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(String input) {
        return Pattern.matches(input, NUMBER_REG);
    }

    private static boolean isPositiveInteger(int num) {
        return num > 0;
    }
}
