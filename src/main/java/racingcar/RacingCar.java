package racingcar;

import racingcar.validator.RacingCarValidator;

public class RacingCar {
    private final int MINIMUM_NUMBER_TO_MOVING_FORWARD = 4;

    private final RandomNumberGenerator randomNumberGenerator;

    private final String name;
    private int distance = 0;
    private String movingBar = "";

    public RacingCar(RacingCarValidator racingCarValidator, RandomNumberGenerator randomNumberGenerator, String name) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
        racingCarValidator.validateName(name);
    }

    public void move() {
        if (canMovingForward()) {
            distance++;
            movingBar += "-";
        }
    }

    private boolean canMovingForward() {
        return randomNumberGenerator.generateRandomNumber() >= MINIMUM_NUMBER_TO_MOVING_FORWARD;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getMovingBar() {
        return movingBar;
    }

    public String getCurrentStatus() {
        return name + " : " + movingBar;
    }
}

