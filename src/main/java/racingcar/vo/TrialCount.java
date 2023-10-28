package racingcar.vo;

import racingcar.exception.TrialCountValidator;

public record TrialCount(Integer number) {

    public TrialCount {
        TrialCountValidator.validateTrialCount(number);
    }
}
