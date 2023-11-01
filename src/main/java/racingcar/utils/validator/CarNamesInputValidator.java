package racingcar.utils.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.configuration.ConfigurationConstants;
import racingcar.utils.CarExceptionMessage;

public class CarNamesInputValidator {
    private static final String SPLIT_REGEX = ",";
    private static final char COMMA = ',';

    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
        validateLastCharacterIsNotComma(target);

        List<String> carNames = Arrays.asList(target.split(SPLIT_REGEX));
        validateEachCarNameIsNotBlank(carNames);
        validateEachCarNameHasCorrectLength(carNames);
        validateEachCarNameIsNotDuplicate(carNames);
        validateTotalCount(carNames);
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

    private static void validateEachCarNameIsNotBlank(List<String> targets) {
        boolean isOnlyBlankNameExists = targets.stream()
                .anyMatch(String::isBlank);

        if (isOnlyBlankNameExists) {
            throw new IllegalArgumentException(CarExceptionMessage.ONLY_BLANK_NAME.getError());
        }
    }

    private static void validateEachCarNameHasCorrectLength(List<String> targets) {
        boolean isWrongLengthNameExists = targets.stream()
                .anyMatch(carName -> carName.length() > ConfigurationConstants.CAR_NAME_LENGTH_MAX_LIMIT);

        if (isWrongLengthNameExists) {
            throw new IllegalArgumentException(CarExceptionMessage.OUT_OF_NAME_LENGTH.getError());
        }
    }

    private static void validateEachCarNameIsNotDuplicate(List<String> targets) {
        boolean isDuplicateNameExists = targets.stream()
                .anyMatch(carName -> Collections.frequency(targets, carName) > 1);

        if (isDuplicateNameExists) {
            throw new IllegalArgumentException(CarExceptionMessage.DUPLICATE_EXISTS.getError());
        }
    }

    private static void validateTotalCount(List<String> targets) {
        if (targets.size() < ConfigurationConstants.TOTAL_CAR_MIN_LIMIT
                || targets.size() > ConfigurationConstants.TOTAL_CAR_MAX_LIMIT) {
            throw new IllegalArgumentException(CarExceptionMessage.OUT_OF_TOTAL_COUNT.getError());
        }
    }
}
