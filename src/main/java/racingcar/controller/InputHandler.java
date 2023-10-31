package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String INTEGER_REG = "^[0-9]*$";

    private InputHandler() {
    }

    public static List<String> parseInputToList(String input) throws IllegalArgumentException {
        List<String> parsedList;
        validateNotEmpty(input);
        parsedList = splitInputByComma(input);
        validateCarNameLength(parsedList);
        return parsedList;
    }

    public static int parseInputToInteger(String input) throws IllegalArgumentException {
        int parsedInt;
        validateNotEmpty(input);
        validateIsNumber(input);
        parsedInt = Integer.parseInt(input);
        validateIsPositiveInteger(parsedInt);
        return parsedInt;
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다. 값을 입력해주세요.");
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        int endInclusive = 5;
        for (String carName : carNames) {
            if (carName.length() > endInclusive) {
                throw new IllegalArgumentException("자동차 이름이 5자 이상입니다. 5자리 이하로 입력해주세요.");
            }
        }
    }

    private static void validateIsNumber(String input) {
        if (!Pattern.matches(INTEGER_REG, input)) {
            throw new IllegalArgumentException("숫자가 아닌 입력값입니다. 숫자를 입력해주세요.");
        }
    }

    private static void validateIsPositiveInteger(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("양의 정수가 아닌 입력값입니다. 양의 정수를 입력해주세요.");
        }
    }
}
