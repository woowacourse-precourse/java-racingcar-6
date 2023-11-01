package racingcar.strategy;

public class RandomRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private static final int DELIMITER_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomRacingCarMoveStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMovable() {
        return randomNumberGenerator.generate() >= DELIMITER_NUMBER;
    }
}
