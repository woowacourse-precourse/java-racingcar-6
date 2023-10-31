package racingcar.domain.racing;

import racingcar.util.RandomNumberGenerator;

public class RacingMovement {
    private static final int MOVING_FORWARD = 4;

    private String name;
    private int number;

    public RacingMovement(String name) {
        this.name = name;
        this.number = RandomNumberGenerator.pick();
    }

    public boolean isMovingForward() { return this.number >= MOVING_FORWARD; }

    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
}