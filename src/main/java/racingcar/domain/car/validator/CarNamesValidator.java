package racingcar.domain.car.validator;

import java.util.Collections;
import java.util.List;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

public class CarNamesValidator {

    private static final int ALLOWED_MAX_NAME_COUNT = 1;

    private CarNamesValidator() {
    }

    public static void validateCarNames(final List<String> names) {
        validateCarNameIsDuplicated(names);
    }

    private static void validateCarNameIsDuplicated(final List<String> names) {
        if (ensureCarNameIsDuplicated(names)) {
            throw new InvalidArgumentException(ErrorMessages.CAR_NAME_IS_DUPLICATED);
        }
    }

    private static boolean ensureCarNameIsDuplicated(final List<String> names) {
        return names.stream()
                .anyMatch(name -> isDuplicated(names, name));
    }

    private static boolean isDuplicated(final List<String> names, final String name) {
        return Collections.frequency(names, name) > ALLOWED_MAX_NAME_COUNT;
    }
}
