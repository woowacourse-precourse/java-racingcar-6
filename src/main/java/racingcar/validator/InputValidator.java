package racingcar.validator;

import java.util.Arrays;
import racingcar.util.Constants;

public class InputValidator {
    public static void validateNotInputComma(final String input) {
        try {
            input.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_COMMA_MESSAGE);
        }
    }

    public static void validateInputCarNameCharacter(final String input) {
        long countNotString = Arrays.stream(input.split(""))
                .filter(str -> str.charAt(0) < 'A' || str.charAt(0) > 'z')
                .count();

        if (countNotString > 0) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CAR_NAME_CHARACTER_MASSAGE);
        }
    }

    public static void validateInputCarNameLength(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public static void validateDuplicationCarNames(final String input) {
        String[] carNames = input.split(",");

        int uniqueCarNames = (int) Arrays.stream(carNames)
                .distinct()
                .count();

        if (carNames.length != uniqueCarNames) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CAR_NAME_DUPLICATION_MESSAGE);
        }
    }

    public static void validateInputTryCountCharacter(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_TRY_COUNT_CHARACTER_MESSAGE);
        }
    }

    public static void validateInputTryCountZero(final String input) {
        if ("0".equals(input)) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_TRY_COUNT_ZERO_MESSAGE);
        }
    }
}
