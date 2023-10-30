package racingcar.model;

import racingcar.validator.InputValidator;

import static racingcar.model.Constants.FIRST_REPEAT;

public class RaceRepetition {
    private final Integer userRepeat;
    private Integer nowRepeat;

    public RaceRepetition(String userRepeat) {
        InputValidator.checkRepetitionIsInteger(userRepeat);
        InputValidator.checkRepetitionIsNonNegative(userRepeat);
        this.userRepeat = Integer.parseInt(userRepeat);
        this.nowRepeat = 0;
    }

    public Boolean isRepetitionEnd() {
        return userRepeat.equals(nowRepeat);
    }
    public void addNowRepeat() {
        this.nowRepeat = this.nowRepeat + 1;
    }
    public Boolean isFirstRepetition() { return nowRepeat.equals(FIRST_REPEAT); }
}
