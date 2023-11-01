package racingcar.domain.strategy;

public class RandomMovingStrategyThreshold {
    private static final int MOVING_THRESHOLD = 4;

    private final int randomNumber;

    private RandomMovingStrategyThreshold(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomMovingStrategyThreshold from(int randomNumber) {
        return new RandomMovingStrategyThreshold(randomNumber);
    }

    public boolean over() {
        return randomNumber >= MOVING_THRESHOLD;
    }
}
