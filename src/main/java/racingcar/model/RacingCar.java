package racingcar.model;

import racingcar.utils.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;

public class RacingCar {
    private final int MOVE_LIMITS = 3;
    private final String racingCarName;
    private int moveCount;

    public RacingCar(final String carName) {
        this.validateNotContainCarName(carName);
        this.validateAlphaCarName(carName);
        this.validateCarNameLength(carName);

        this.racingCarName = carName;
        this.moveCount = 0;
    }

    public void move(final int movableNumber) {
        if (movableNumber > MOVE_LIMITS) {
            moveCount += 1;
        }
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public Score getScore() {
        final Score score = new Score(this.racingCarName, this.moveCount);

        return score;
    }

    public void validateNotContainCarName(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_NAME_ERROR.getNoCarsNameError());
        }
    }

    public void validateAlphaCarName(final String name) {
        if (!Pattern.matches("^[a-zA-Z]*$", name)) {
            throw new IllegalArgumentException(ErrorMessage.ALPHA_NAME_ERROR.getAlphaCarNameError());
        }
    }

    public void validateCarNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getCarNameLengthError());
        }
    }

}
