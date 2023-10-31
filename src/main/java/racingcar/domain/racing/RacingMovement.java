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
}