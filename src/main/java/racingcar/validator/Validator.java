package racingcar.validator;

import static racingcar.constant.MessageConstant.CAR_NAME_CONTAINS_SPACE_ERROR;
import static racingcar.constant.MessageConstant.CAR_NAME_INPUT_COUNT_ERROR;
import static racingcar.constant.MessageConstant.CAR_NAME_INPUT_DUPLICATE_ERROR;
import static racingcar.constant.MessageConstant.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.MessageConstant.TOTAL_ROUND_INPUT_ERROR;
import static racingcar.constant.SystemConstant.CAR_NAME_LENGTH_MAX;
import static racingcar.constant.SystemConstant.CAR_NAME_LENGTH_MIN;
import static racingcar.constant.SystemConstant.NUMBER_PATTERN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    public static List<String> validateCarNameInput(String input) {
        validateCarNameInputLength(input);
        List<String> carNames = List.of(input.split(","));
        validateDuplicateCarName(carNames);
        return carNames;
    }

    private static void validateCarNameInputLength(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_COUNT_ERROR.getMessage());
        }
    }

    private static void validateDuplicateCarName(List<String> carNames) {
        Set<String> carNameSet = new HashSet<>(carNames);

        if (carNames.size() != carNameSet.size()) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_DUPLICATE_ERROR.getMessage());
        }
    }

    public static void validateCheckCarName(String carName) {
        validateCheckCarNameLength(carName);
        validateCheckCarNameContainsSpace(carName);
    }

    private static void validateCheckCarNameLength(String catName) {
        if (catName.length() > CAR_NAME_LENGTH_MAX || catName.length() < CAR_NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    private static void validateCheckCarNameContainsSpace(String catName) {
        if (catName.contains(" ")) {
            throw new IllegalArgumentException(CAR_NAME_CONTAINS_SPACE_ERROR.getMessage());
        }
    }

    public static void validateTotalTurnInput(String input) {
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException(TOTAL_ROUND_INPUT_ERROR.getMessage());
        }
    }
}
