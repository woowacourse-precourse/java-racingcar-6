package racingcar.util.Validator;

import java.util.List;
import racingcar.view.input.error.InputError;
import racingcar.view.input.error.InputIllegalArgumentException;

public class Validator {

    public static final int MAXIMUM_NAME_LENGTH = 6;
    public static final int MINIMUM_NAME_LENGTH = 0;

    public static void validateNameLength(List<String> names) {
        int countNames = (int) names.stream()
                .filter(name -> name.length() < MAXIMUM_NAME_LENGTH && name.length() != MINIMUM_NAME_LENGTH)
                .count();

        if (countNames != names.size()) {
            throw new InputIllegalArgumentException(InputError.EXCEEDED_MAXIMUM_ERROR);
        }
    }
}
