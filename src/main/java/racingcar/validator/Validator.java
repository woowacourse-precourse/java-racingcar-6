package racingcar.validator;

import static racingcar.constant.MessageConstant.CAR_NAME_INPUT_COUNT_ERROR;
import static racingcar.constant.MessageConstant.CAR_NAME_INPUT_DUPLICATE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
