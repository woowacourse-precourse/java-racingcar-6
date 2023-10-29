package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class RacingCarRound {
    private int number;
    private boolean gameState;

    public RacingCarRound(String number) {
        RacingCarValidator.numberAttemptsInputValidator(number);
        this.number = Integer.parseInt(number);
        this.gameState = true;
    }


    public boolean isGameState() {
        return gameState;
    }

    private void gameSetCheck() {
        if (this.number == 0) {
            this.gameState = false;
        }
    }

    private void setNumber() {
        this.number -= 1;
    }

    public void roundStart() {
        setNumber();
        gameSetCheck();
    }



}
