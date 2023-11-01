package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> inputCarNames() {
        String input = Console.readLine();
        validateCarNames(input);
        return Arrays.stream(input.split(",")).toList();
    }

    public static int inputTryCount() {
        String input = Console.readLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    public static void validateCarNames(String input) {
        validateNotNull(input);
        validateNotStartOrEndWithComma(input);
        validateNoConsecutiveCommas(input);
        validateNoCommasWithSpaces(input);
    }

    public static void validateTryCount(String input) {
        validateNotNull(input);
        validateIsNumeric(input);
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null 입니다");
        }
    }

    private static void validateNotStartOrEndWithComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("입력의 시작이나 끝에 쉼표가 있습니다");
        }
    }

    private static void validateNoConsecutiveCommas(String input) {
        if (input.contains(",,") || input.contains(", ,")) {
            throw new IllegalArgumentException("쉼표가 연속해서 있습니다");
        }
    }

    private static void validateNoCommasWithSpaces(String input) {
        if (input.contains(" ,") || input.contains(", ")) {
            throw new IllegalArgumentException("쉼표 옆에 공백이 있습니다");
        }
    }

    private static void validateIsNumeric(String input) {
        if (input.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("입력은 숫자만 포함해야 합니다.");
        }
    }


}
