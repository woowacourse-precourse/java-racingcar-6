package racingcar;

import racingcar.constant.FixedNumber;
import racingcar.validator.RacingCarValidator;

public class RacingCar {
    private final RandomNumberGenerator randomNumberGenerator;

    private final String name;
    private int distance = 0;
    private String movingBar = "";

    public RacingCar(
            RacingCarValidator racingCarValidator,
            RandomNumberGenerator randomNumberGenerator,
            String name
    ) {
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
        return randomNumberGenerator.generateRandomNumber() >= FixedNumber.MIN_MOVING_FORWARD.getValue();
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

