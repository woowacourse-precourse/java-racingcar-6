package racingcar.model;

import racingcar.validator.InputValidator;

public class UserRepetition {
    private final Integer userRepeat;
    private Integer nowRepeat;

    public UserRepetition(String userRepeat) {
        InputValidator.checkRepetitionIsNumber(userRepeat);
        InputValidator.checkRepetitionIsPositive(userRepeat);
        this.userRepeat = Integer.parseInt(userRepeat);
        this.nowRepeat = 0;
    }

    public Boolean isRepetitionEnd() {
        return userRepeat.equals(nowRepeat);
    }
    public void addNowRepeat() {
        this.nowRepeat = this.nowRepeat + 1;
    }
}
