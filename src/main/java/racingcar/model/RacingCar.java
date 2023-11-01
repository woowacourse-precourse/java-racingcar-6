package racingcar.model;

import racingcar.utils.ErrorMessage;

import java.util.regex.Pattern;

public class RacingCar {
    private final int MOVE_LIMITS = 3;
    private final String ENG_REGEX = "^[a-zA-Z]*$";
    private final int CAR_NAME_LENGTH_LIMITS = 5;
    private final String racingCarName;
    private int moveCount;

    public RacingCar(final String carName) {
        this.validateCarNameNotEmpty(carName);
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

    public void validateCarNameNotEmpty(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_NAME_ERROR.getMessage());
        }
    }

    public void validateAlphaCarName(final String name) {
        if (!Pattern.matches(ENG_REGEX, name)) {
            throw new IllegalArgumentException(ErrorMessage.ALPHA_NAME_ERROR.getMessage());
        }
    }

    public void validateCarNameLength(final String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMITS) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

}
