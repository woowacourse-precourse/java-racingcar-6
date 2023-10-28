package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constant;

public class RandomMoveGenerator {
	public static boolean isMovable() {
		return Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_MIN, Constant.RANDOM_NUMBER_MAX) >= Constant.RANDOM_NUMBER_THRESHOLD;
	}
}
