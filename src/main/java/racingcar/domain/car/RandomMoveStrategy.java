package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy{

	private static final int MIN_MOVING_VALUE = 4;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 9;

	@Override
	public int move() {
		if (generate()>= MIN_MOVING_VALUE) {
			return MoveState.FORWARD.getDistance();
		}
		return MoveState.STOP.getDistance();
	}


	private int generate() {
		return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
	}
}