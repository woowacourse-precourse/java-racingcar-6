package racingcar.util;

import static racingcar.enums.ExceptionMessage.NAME_CANNOT_BE_BLANK;
import static racingcar.enums.ExceptionMessage.SHOULD_BE_FIVE_LETTERS_OR_BELOW;
import static racingcar.enums.ExceptionMessage.SHOULD_HAVE_UNIQUE_NAMES;
import static racingcar.enums.ExceptionMessage.SHOULD_INPUT_MORE_THAN_ONE_NAME;
import static racingcar.enums.ExceptionMessage.SHOULD_INPUT_ONLY_NUMBER;
import static racingcar.enums.ExceptionMessage.TOO_LONG_INPUT;
import static racingcar.enums.StringPattern.TRIAL_COUNT;
import static racingcar.enums.Symbol.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static final Pattern TRIAL_COUNT_PATTERN = Pattern.compile(TRIAL_COUNT.getPattern());

    private ValidationUtils() {
    }

    public static void validateCarNames(String input) {
        if (isOver10000Letters(input)) {
            throw new IllegalArgumentException(TOO_LONG_INPUT.getMessage());
        }

        if (hasNameOver5Letters(input)) {
            throw new IllegalArgumentException(SHOULD_BE_FIVE_LETTERS_OR_BELOW.getMessage());
        }

        if (hasBlankName(input)) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_BLANK.getMessage());
        }

        if (hasEmptyName(input)) {
            throw new IllegalArgumentException(SHOULD_INPUT_MORE_THAN_ONE_NAME.getMessage());
        }

        if (hasNotUniqueNames(input)) {
            throw new IllegalArgumentException(SHOULD_HAVE_UNIQUE_NAMES.getMessage());
        }
    }

    private static boolean isOver10000Letters(String input) {
        return input.length() > 10000;
    }

    private static boolean hasNameOver5Letters(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER.getValue()))
                .anyMatch(carName -> carName.length() > 5);
    }

    private static boolean hasBlankName(String input) {
        return input == null
                || input.isBlank()
                || input.contains(CAR_NAME_DELIMITER.getValue().repeat(2));
    }

    private static boolean hasEmptyName(String input) {
        return !input.contains(CAR_NAME_DELIMITER.getValue());
    }

    private static boolean hasNotUniqueNames(String input) {
        String[] carNames = input.split(CAR_NAME_DELIMITER.getValue());
        HashSet<String> carNameSet = new HashSet<>(List.of(carNames));
        return carNameSet.size() != carNames.length;
    }

    public static void validateTrialCount(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(SHOULD_INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private static boolean isNotNumber(String input) {
        return !TRIAL_COUNT_PATTERN.matcher(input)
                .matches();
    }
}
