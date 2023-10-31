package racingcar.util.validator;

import static racingcar.util.ConstantNumbers.MAXIMUM_NAME_LENGTH;
import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.exception.ErrorMessage;
import racingcar.util.exception.RacingCarException;

public class InputValidator implements Validator {
    InputValidator() {}
    public void isValidList(final List<String> names) {
        if (!hasValidNames(names)) {
            throw RacingCarException.of(ErrorMessage.INVALID_NAME);
        }

        if (!hasDistinctName(names)) {
            throw RacingCarException.of(ErrorMessage.DUPLICATE_NAME);
        }
    }

    public Integer isPositiveInteger(final String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        } catch (Exception e) {
            throw RacingCarException.of(ErrorMessage.NOT_INTEGER);
        }

        if (isNegative(number)) {
            throw RacingCarException.of(ErrorMessage.NOT_POSITIVE);
        }

        return number;
    }
    private boolean hasValidNames(final List<String> names) {
        for (String name:names) {
            if (name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH.number()) {
                return false;
            }
        }

        return true;
    }

    private boolean hasDistinctName(final List<String> names) {
        List<String> checkList = new ArrayList<>();
        for (String name:names) {
            if (checkList.contains(name)) {
                return false;
            }
            checkList.add(name);
        }

        return true;
    }

    private boolean isNegative(final int number) {
        return number < MINIMUM_TRY_COUNT.number();
    }
}
