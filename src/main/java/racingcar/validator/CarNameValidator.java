package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
import racingcar.enums.RegexPattern;
import racingcar.enums.Separator;

public class CarNameValidator {
    private static final int MAX_RANGE = 5;
    private static final int MIM_RANGE = 1;

    private CarNameValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateSeparator(input);
        validateEndWithComma(input);
        validateCarName(input);
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }

    private static void validateSeparator(String input) {
        if (!RegexPattern.INCLUDE_COMMA.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    private static void validateEndWithComma(String input) {
        if (input.endsWith(Separator.COMMA.toString())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_END_WITH_COMMA.getMessage());
        }
    }

    private static void validateCarName(String input) {
        String[] carNames = input.split(Separator.COMMA.toString());
        validateParticipatingCarCount(carNames.length);
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            validateCarNameCond(carName);
            validateCarNameLength(carName);
            validateCarNameIsBlank(carName);
            validateIsStartBlank(carName);
            validateIsEndBlank(carName);
            nameSet.add(carName);
        }
        validateDuplication(nameSet.size(), carNames.length);
    }

    private static void validateParticipatingCarCount(int carCount) {
        if (carCount <= MIM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.PARTICIPATION_CAR_COUNT.getMessage());
        }
    }

    private static void validateCarNameCond(String carName) {
        if (!RegexPattern.CAR_NAME_COND.matches(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_COND.getMessage());
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_RANGE || carName.length() < MIM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NAME_BETWEEN_ONE_AND_FIVE.getMessage());
        }
    }

    private static void validateCarNameIsBlank(String carName) {
        if (carName.equals(Separator.BLANK.toString())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_REPLACED_BLANK.getMessage());
        }
    }

    private static void validateIsStartBlank(String carName) {
        if (RegexPattern.BLANK_IN_START.matches(carName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_START.getMessage());
        }
    }

    private static void validateIsEndBlank(String carName) {
        if (RegexPattern.BLANK_IN_END.matches(carName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_END.getMessage());
        }
    }

    private static void validateDuplication(int nameSetSize, int carCount) {
        if (nameSetSize != carCount) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION.getMessage());
        }
    }
}
