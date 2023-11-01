package racingcar.utils.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.configuration.ConfigurationConstants;
import racingcar.utils.CarExceptionMessage;

public class CarNamesInputValidator {
    private static final String SPLIT_REGEX = ",";
    private static final char COMMA = ',';

    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
        validateLastCharacterIsNotComma(target);

        String[] elements = target.split(SPLIT_REGEX);
        validateEachElementIsNotBlank(elements);
        validateEachElementCorrectLength(elements);
        validateNonDuplicate(elements);
        validateTotalCount(elements);
    }

    private static void validateIsNotBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(CarExceptionMessage.BLANK_INPUT.getError());
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(CarExceptionMessage.ONLY_BLANK_NAME.getError());
        }
    }

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
            throw new IllegalArgumentException(CarExceptionMessage.ONLY_BLANK_NAME.getError());
        }
    }

    private static void validateEachElementIsNotBlank(String[] targets) {
        for (String target : targets) {
            if (target.isBlank()) {
                throw new IllegalArgumentException(CarExceptionMessage.ONLY_BLANK_NAME.getError());
            }
        }
    }

    private static void validateEachElementCorrectLength(String[] targets) {
        for (String target : targets) {
            if (target.length() > ConfigurationConstants.CAR_NAME_LENGTH_MAX_LIMIT) {
                throw new IllegalArgumentException(CarExceptionMessage.OUT_OF_NAME_LENGTH.getError());
            }
        }
    }

    private static void validateNonDuplicate(String[] targets) {
        List<String> distinctTargets = Arrays.stream(targets)
                .distinct()
                .collect(Collectors.toList());
        if (distinctTargets.size() != targets.length) {
            throw new IllegalArgumentException(CarExceptionMessage.DUPLICATE_EXISTS.getError());
        }
    }

    private static void validateTotalCount(String[] targets) {
        if (targets.length < ConfigurationConstants.TOTAL_CAR_MIN_LIMIT
                || targets.length > ConfigurationConstants.TOTAL_CAR_MAX_LIMIT) {
            throw new IllegalArgumentException(CarExceptionMessage.OUT_OF_TOTAL_COUNT.getError());
        }
    }
}
