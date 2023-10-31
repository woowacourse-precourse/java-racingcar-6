package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class InputManager {
    static List<String> getCarNames() {
        return getCarNames(Console.readLine());
    }

    static List<String> getCarNames(String input) {
        validateComma(input);
        List<String> carNames = Arrays.asList(input.split(","));
        validateEachNameLength(carNames);
        validateEachNameIsNotOnlyBlank(carNames);
        validateNameCount(carNames);
        return carNames;
    }

    private static void validateComma(String input) {
        int lastIndex = input.length() - 1;
        if (input.charAt(lastIndex) == ',') {
            throw new IllegalArgumentException(ExceptionMessage.COMMA_MESSAGE);
        }
    }

    private static void validateEachNameLength(List<String> names) {
        boolean findIllegalLength = names.stream().anyMatch(s -> s.length() < 1 || s.length() > 5);
        if (findIllegalLength) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH);
        }
    }

    private static void validateEachNameIsNotOnlyBlank(List<String> names) {
        boolean findIllegalBlank = names.stream().anyMatch(String::isBlank);
        if (findIllegalBlank) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_BLANK);
        }
    }

    private static void validateNameCount(List<String> names) {
        int nameCount = names.size();
        if (nameCount > 10000) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_COUNT);
        }
    }

    static int getMoveTryCount() {
        return getMoveTryCount(Console.readLine());
    }

    static int getMoveTryCount(String input) {
        try {
            int moveTryCount = Integer.parseInt(input);
            checkZeroOrPositive(moveTryCount);
            return moveTryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.POSITIVE_INTEGER);
        }
    }

    private static void checkZeroOrPositive(int moveTryCount) {
        if (moveTryCount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.POSITIVE_INTEGER);
        }
    }
}
