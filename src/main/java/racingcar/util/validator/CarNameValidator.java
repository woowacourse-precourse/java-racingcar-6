package racingcar.util.validator;

import java.util.List;
import racingcar.util.ExceptionMessage;
import racingcar.util.Util;

public class CarNameValidator extends Validator {
    private static final CarNameValidator instance = new CarNameValidator();

    public static CarNameValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(String input) {
        List<String> checks = Util.splitNameByComma(input);
        checkCarCount(checks);
        checkNameLength(checks);
    }

    private void checkNameLength(List<String> checks) {
        for (String check : checks) {
            if (check.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    private void checkCarCount(List<String> checks) {
        if (checks.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT.getMessage());
        }
    }
}
