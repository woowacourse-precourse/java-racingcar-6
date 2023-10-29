package racingcar.validation;

import java.util.regex.Pattern;

public class GameCountValidator {

    private static final Pattern GAME_COUNT_REGEX = Pattern.compile("[0-9]+");
    private static final String GAME_COUNT_TYPE_EXCEPTION_MESSAGE = "게임 횟수는 자연수여야 한다.";

    public void validateGameCount(String userInput) {
        if (!validateCountType(userInput) || validateStartZero(userInput)) {
            throw new IllegalArgumentException(GAME_COUNT_TYPE_EXCEPTION_MESSAGE);
        }
    }

    private boolean validateCountType(String userInput) {
        return GAME_COUNT_REGEX.matcher(userInput).matches();
    }

    private boolean validateStartZero(String userInput) {
        return userInput.charAt(0) == '0';
    }
}
