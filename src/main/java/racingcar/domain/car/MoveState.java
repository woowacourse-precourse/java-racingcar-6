package racingcar.domain.car;

import racingcar.domain.generator.NumberGenerator;

public class MoveState {

	private static final int MIN_MOVING_VALUE = 4;
	private final NumberGenerator numberGenerator;

	public MoveState(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public boolean canMove() {
		return numberGenerator.generate() >= MIN_MOVING_VALUE;
	}
}