package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNameValidator {
    private static final Pattern INCLUDE_COMMA = Pattern.compile(".*,.*");
    private static final Pattern CAR_NAME_COND = Pattern.compile("^[\\sa-zA-Z0-9가-힣]*$");
    private static final Pattern BLANK_IN_START = Pattern.compile("^\\s.*");
    private static final Pattern BLANK_IN_END = Pattern.compile(".*\\s$");
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final int MAX_RANGE = 5;
    private static final int MIM_RANGE = 1;

    private CarNameValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateSeparator(input);
        validateCarName(input);
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR);
        }
    }

    private static void validateSeparator(String input) {
        if (!INCLUDE_COMMA.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA);
        }
    }

    private static void validateCarName(String input) {
        String[] carNames = input.split(COMMA);
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
        if (carCount == 1) {
            throw new IllegalArgumentException(ErrorMessage.PARTICIPATION_CAR_COUNT);
        }
    }

    private static void validateCarNameCond(String carName) {
        if (!CAR_NAME_COND.matcher(carName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_COND);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_RANGE || carName.length() < MIM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NAME_BETWEEN_ONE_AND_FIVE);
        }
    }

    private static void validateCarNameIsBlank(String carName) {
        if (carName.equals(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_REPLACED_BLANK);
        }
    }

    private static void validateIsStartBlank(String carName) {
        if (BLANK_IN_START.matcher(carName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_START);
        }
    }

    private static void validateIsEndBlank(String carName) {
        if (BLANK_IN_END.matcher(carName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_END);
        }
    }

    private static void validateDuplication(int nameSetSize, int carCount) {
        if (nameSetSize != carCount) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION);
        }
    }
}
