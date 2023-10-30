package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class RacingCarRound {
    private int round;
    private boolean gameState;

    public RacingCarRound(String number) {
        RacingCarValidator.numberAttemptsInputValidator(number);
        this.round = Integer.parseInt(number);
        this.gameState = true;
    }

    public int getRound() {
        return round;
    }

    public boolean isGameState() {
        return gameState;
    }

    private void gameSetCheck() {
        if (this.round == 0) {
            this.gameState = false;
        }
    }

    private void setNumber() {
        this.round -= 1;
    }

    public void roundStart() {
        setNumber();
        gameSetCheck();
    }
}
