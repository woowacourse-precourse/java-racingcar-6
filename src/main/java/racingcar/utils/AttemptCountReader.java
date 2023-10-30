package racingcar.utils;

import racingcar.validator.AttemptCountValidator;
import racingcar.view.InputView;

public class AttemptCountReader {

    public static int get() {
        String attemptCount = InputView.getAttemptCount();
        return AttemptCountValidator.validateAttemptCount(attemptCount);
    }
}
