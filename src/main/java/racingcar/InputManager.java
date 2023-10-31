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
            throw new IllegalArgumentException("마지막 글자가 콤마가 될 수 없습니다!");
        }
    }

    private static void validateEachNameLength(List<String> names) {
        boolean findIllegalLength = names.stream().anyMatch(s -> s.length() < 1 || s.length() > 5);
        if (findIllegalLength) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private static void validateEachNameIsNotOnlyBlank(List<String> names) {
        boolean findIllegalBlank = names.stream().anyMatch(String::isBlank);
        if (findIllegalBlank) {
            throw new IllegalArgumentException("자동차의 이름에는 공백이 아닌 문자가 한개 이상 포함되어야 합니다.");
        }
    }

    private static void validateNameCount(List<String> names) {
        int nameCount = names.size();
        if (nameCount > 10000) {
            throw new IllegalArgumentException("자동차의 개수가 너무 많습니다!");
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
            throw new IllegalArgumentException("0 이상의 int 정수가 아닙니다!");
        }
    }

    private static void checkZeroOrPositive(int moveTryCount) {
        if (moveTryCount < 0) {
            throw new IllegalArgumentException("0 이상의 int 정수가 아닙니다!");
        }
    }
}
