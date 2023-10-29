package racingcar;

public class RandomMovingStrategy implements MovingStrategy {

	private static final int MIN_MOVING_VALUE = 4;
	private final RandomGenerator randomGenerator;

	public RandomMovingStrategy(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	@Override
	public boolean canMove() {
		return randomGenerator.generate() >= MIN_MOVING_VALUE;
	}
}

