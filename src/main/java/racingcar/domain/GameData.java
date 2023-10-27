package racingcar.domain;

import java.util.List;
import racingcar.message.ErrorMessage;

public record GameData(Cars cars, int trialCount) {
    public GameData {
        validateTrial(trialCount);
    }

    private void validateTrial(int trialCount) {
        if (trialCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_COUNT);
        }
    }
}
