package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class RacingCarRound {
    private int round;

    public RacingCarRound(String number) {
        RacingCarValidator.numberAttemptsInputValidator(number);
        this.round = Integer.parseInt(number);
    }

    private void endRound() {
        this.round -= 1;
    }

    public int getRound() {
        return round;
    }

    public boolean gameCheck() {
        if (this.round == 0) {
            return false;
        }
        return true;
    }

    public void roundStart() {
        endRound();
    }
}
