package racingcar;

public class RandomMoveState implements MoveSate {

	private static final int MIN_MOVING_VALUE = 4;
	private final RandomGenerator randomGenerator;

	public RandomMoveState(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	@Override
	public boolean canMove() {
		return randomGenerator.generate() >= MIN_MOVING_VALUE;
	}
}

