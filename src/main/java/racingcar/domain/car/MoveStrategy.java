package racingcar.domain.car;

import racingcar.domain.generator.NumberGenerator;

public class MoveStrategy {

	private static final int MIN_MOVING_VALUE = 4;

	public boolean canMove(NumberGenerator numberGenerator) {
		return numberGenerator.generate() >= MIN_MOVING_VALUE;
	}
}