package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String NUMBER_REGEX = "[^0-9]";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public static String getUserInput() {
        return Console.readLine().trim();
    }

    public static Integer getUserInputNumber() {
        String userInput = Console.readLine();

        validateIsNumber(userInput);

        return convertToInt(userInput);
    }

    private static void validateIsNumber(String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException("user input is not number. user input : " + userInput);
        }
    }

    private static boolean isNotNumber(String userInput) {
        Matcher matcher = NUMBER_PATTERN.matcher(userInput);
        return matcher.matches();
    }

    private static Integer convertToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
