package racingcar.util.validator;

import racingcar.util.ExceptionMessage;
import racingcar.util.Util;

public class AttemptCountValidator extends Validator {
    private static final AttemptCountValidator instance = new AttemptCountValidator();

    public static AttemptCountValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(String input) {
        int check = Util.convertStringToInt(input);
        checkCountRange(check);
    }

    private void checkCountRange(int check) {
        if (check < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT_RANGE.getMessage());
        }
    }
}
