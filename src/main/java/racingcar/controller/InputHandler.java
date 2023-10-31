package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private InputHandler() {
    }

    public static List<String> parseInputToList(String input) throws IllegalArgumentException {
        List<String> parsedList;
        parsedList = splitInputByComma(input);
        if (!validateCarNameLength(parsedList)) {
            throw new IllegalArgumentException("잘못된 입력 값입니다");
        }
        return parsedList;
    }

    public static int parseInputToIntager(String input) {
        int parsedInt = 0;
        return parsedInt;
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static boolean validateCarNameLength(List<String> carNames) {
        int endinclusive = 5;
        for (String carName : carNames) {
            if (carName.length() <= endinclusive) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPositiveInteger(int num) {
        return false;
    }
}
