package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private InputHandler() {
    }

    public static List<String> parseInputToList(String input) {
        List<String> parsedList;
        parsedList = splitInputByComma(input);
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
        return false;
    }

    private static boolean isPositiveInteger(int num) {
        return false;
    }
}
