package racingcar.domain.car;

import racingcar.domain.generator.NumberGenerator;

public class MoveStrategy {

	private static final int MIN_MOVING_VALUE = 4;

	public int move(NumberGenerator numberGenerator) {
		if(numberGenerator.generate() >= MIN_MOVING_VALUE){
			return MoveState.FORWARD.getDistance();
		}
		return MoveState.STOP.getDistance();
	}
}