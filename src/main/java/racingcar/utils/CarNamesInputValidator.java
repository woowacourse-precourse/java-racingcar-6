package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.configuration.ConfigurationConstants;

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
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.BLANK_INPUT.getError());
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }
    }

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }
    }

    private static void validateEachElementIsNotBlank(String[] targets) {
        for (String target : targets) {
            if (target.isBlank()) {
                throw new IllegalArgumentException(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
            }
        }
    }

    private static void validateEachElementCorrectLength(String[] targets) {
        for (String target : targets) {
            if (target.length() > ConfigurationConstants.CAR_NAME_LENGTH_MAX_LIMIT) {
                throw new IllegalArgumentException(CarNamesInputExceptionMessage.OUT_OF_LENGTH.getError());
            }
        }
    }

    private static void validateNonDuplicate(String[] targets) {
        List<String> distinctTargets = Arrays.stream(targets)
                .distinct()
                .collect(Collectors.toList());
        if (distinctTargets.size() != targets.length) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.DUPLICATE_EXISTS.getError());
        }
    }

    private static void validateTotalCount(String[] targets) {
        if (targets.length < ConfigurationConstants.TOTAL_CAR_MIN_LIMIT
                || targets.length > ConfigurationConstants.TOTAL_CAR_MAX_LIMIT) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.OUT_OF_TOTAL_COUNT.getError());
        }
    }

    enum CarNamesInputExceptionMessage {
        BLANK_INPUT("공백 입력을 해선 안됩니다."),
        CAR_NAME_BLANK("자동차 이름은 공백 문자로만 이루어져선 안됩니다."),
        OUT_OF_LENGTH("자동차 이름은 5글자 이하여야 합니다."),
        DUPLICATE_EXISTS("중복된 자동차 이름이 존재합니다."),
        OUT_OF_TOTAL_COUNT(String.format("자동차이름은 %d ~ %d 개만 입력 가능합니다.", ConfigurationConstants.TOTAL_CAR_MIN_LIMIT,
                ConfigurationConstants.TOTAL_CAR_MAX_LIMIT));

        private final String error;

        CarNamesInputExceptionMessage(String error) {
            this.error = error;
        }

        String getError() {
            return error;
        }
    }
}
