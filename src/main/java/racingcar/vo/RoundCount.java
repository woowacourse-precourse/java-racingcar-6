package racingcar.vo;

import racingcar.exception.RoundCountValidator;

public class RoundCount {
    private final int count;

    public RoundCount(String count) {
        RoundCountValidator.validate(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }
}
