package racingcar.utils;

import java.util.List;
import racingcar.exception.RacingCarException;

public class UserInputValidator {

    private final int MAX_NAME_LENGTH = 5;

    public void validateCarNames(List<String> carNames) {
        checkNameLength(carNames);
        checkNameEmpty(carNames);
    }

    public void validateTryCount(String count) {
        checkCountLength(count);
        checkCountNumber(count);
    }

    private void checkNameEmpty(List<String> carNames) {
        for (String split : carNames) {
            if (split.isBlank()) {
                throw new IllegalArgumentException(RacingCarException.INVALID_BLANK_NAME_MSG);
            }
        }
    }

    private void checkCountLength(String count) {
        if (count.isEmpty()) {
            throw new IllegalArgumentException(RacingCarException.INVALID_TRY_COUNT_LENGTH_MSG);
        }
    }

    private void checkNameLength(List<String> splits) {
        for (String split : splits) {
            if (split.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(RacingCarException.INVALID_CAR_NAME_LENGTH_MSG);
            }
        }
    }

    private void checkCountNumber(String count) {
        try {
            int i = Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RacingCarException.INVALID_NUMBER_MSG);
        }
    }
}
