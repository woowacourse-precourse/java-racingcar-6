package racingcar.validation;

import java.util.regex.Pattern;
import racingcar.constant.ExceptionMessage;

public class GameCountValidator {

    private static final Pattern GAME_COUNT_REGEX = Pattern.compile("[0-9]+");

    public static void validateGameCount(String userInput) {
        if (!validateCountType(userInput) || validateStartZero(userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_COUNT_TYPE.getMessage());
        }
    }

    private static boolean validateCountType(String userInput) {
        return GAME_COUNT_REGEX.matcher(userInput).matches();
    }

    private static boolean validateStartZero(String userInput) {
        return userInput.charAt(0) == '0';
    }
}
