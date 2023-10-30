package racingcar;

public class RacingCar {
    private final int MINIMUM_NUMBER_TO_MOVING_FORWARD = 4;
    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    private int distance = 0;
    private String movingBar = "";

    public RacingCar(RandomNumberGenerator randomNumberGenerator, String name) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
    }


    private boolean canMovingForward() {
        return randomNumberGenerator.generateRandomNumber() >= MINIMUM_NUMBER_TO_MOVING_FORWARD;
    }
}
