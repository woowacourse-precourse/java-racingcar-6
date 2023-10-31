package racingcar.domain.racing;

import racingcar.util.RandomNumberGenerator;

public class RacingMovement {
    private static final int MOVING_FORWARD = 4;
    private int number;

    public RacingMovement(Integer number) {
        this.number = number;
    }

    public static RacingMovement random() {
        int randomNumber = RandomNumberGenerator.pick();
        return new RacingMovement(randomNumber);
    }

    public boolean isMovingForward() {
        return this.number >= MOVING_FORWARD;
    }

    public boolean isStop() { return this.number < MOVING_FORWARD; }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }
}