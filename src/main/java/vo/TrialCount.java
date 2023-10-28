package vo;

import racingcar.exception.TrialCountValidator;

public class TrialCount {
    
    private final Integer number;

    public TrialCount(Integer number) {
        TrialCountValidator.validateTrialCount(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
