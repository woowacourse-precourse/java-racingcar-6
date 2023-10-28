package racingcar.util.Validator;

import java.util.List;
import racingcar.domain.input.error.InputError;
import racingcar.domain.input.error.InputException;

public class Validator {

    private static final int MAXIMUM_FORWARD_NUMBER = 4;

    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void validateNameLength(List<String> names) {

        long countNames = names.stream()
                .filter(name -> name.length() < MAXIMUM_NAME_LENGTH)
                .count();

        if (countNames != names.size()) {
            throw new InputException(InputError.EXCEEDED_MAXIMUM_ERROR);
        }
    }

    public static boolean isCanForward(int forwardNumber) {
        return MAXIMUM_FORWARD_NUMBER <= forwardNumber;
    }
}
