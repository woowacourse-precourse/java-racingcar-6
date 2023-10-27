package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.config.GameConfig;

public class InputUtil {

    public static List<String> readStringList() {
        String input = readLine();
        validateDelimiter(input);
        return Arrays.stream(input.split(GameConfig.CAR_NAME_DELIMITER))
                .filter(InputUtil::validateHasInput)
                .toList();
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(GameConfig.CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    public static int readInt() {
        return parseToInteger(readLine());
    }

    private static int parseToInteger(String input) {
        validateDigit(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigit(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    private static String readLine() {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }

    private static boolean validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
