package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Constants;

public class InputValidator {
    public static void validateNotInputComma(final String input) {
        if (input.length() > Constants.MAX_CAR_NAME_LENGTH) {
            validateContainsComma(input);
        }
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_COMMA_MESSAGE);
        }
    }

    public static void validateInputCarNameCharacter(final String input) {
        long countNotString = Arrays.stream(input.split(""))
                .filter(str -> !",".equals(str) && !" ".equals(str))
                .filter(str -> str.charAt(0) < 'A' || str.charAt(0) > 'z')
                .count();

        if (countNotString > 0) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CAR_NAME_CHARACTER_MASSAGE);
        }
    }

    public static void validateInputCarNameLength(final String input) {
        long count = Arrays.stream(input.split(","))
                .filter(str -> str.length() > Constants.MAX_CAR_NAME_LENGTH)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public static void validateDuplicationCarNames(final String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        int countDuplicate = 0;

        for (String carName : carNames) {
            countDuplicate = (int) carNames.stream()
                    .filter(name -> name.equals(carName))
                    .count();
        }

        if (countDuplicate > 1) {
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
