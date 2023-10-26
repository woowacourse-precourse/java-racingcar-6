package racingcar;

import java.util.List;

public record GameData(List<Car> carList, int trialCount) {
    public GameData {
        validateTrial(trialCount);
    }

    private void validateTrial(int trialCount) {
        if (trialCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_COUNT);
        }
    }
}
