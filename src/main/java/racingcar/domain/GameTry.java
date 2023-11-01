package racingcar.domain;

import static racingcar.util.ExceptionMessage.INVALID_GAME_TRY_INPUT;
import static racingcar.util.ExceptionMessage.INVALID_NUMERIC_GAME_TRY;

public class GameTry {
    private int gameTry;

    public GameTry(String gameTry) {
        this.gameTry = validateTry(parseInt(gameTry));
    }

    private int validateTry(int targetGameTry) {
        if (targetGameTry < 0) {
            throw new IllegalArgumentException(INVALID_GAME_TRY_INPUT.getMessage());
        }
        return targetGameTry;
    }

    private int parseInt(String inputTry) {
        try {
            return Integer.parseInt(inputTry);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_GAME_TRY.getMessage());
        }
    }

    public int getGameTry() {
        return gameTry;
    }

    public boolean isNotGameEnd(int TargetGameTry) {
        return this.gameTry != TargetGameTry;
    }

    public void increase() {
        this.gameTry++;
    }
}
