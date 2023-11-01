package racingcar.model;

import racingcar.util.validator.InputValidator;

public class Game {
    private int tryCount;

    public Game(String tryCount) {
        InputValidator.checkTryCountInputValidation(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public boolean isGameEnd() {
        if (tryCount <= 0) {
            return true;
        }
        tryCount--;
        return false;
    }
}
