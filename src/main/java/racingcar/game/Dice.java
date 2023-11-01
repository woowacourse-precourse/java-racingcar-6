package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
	public static final int MIN_LIMIT = 0;
	public static final int MAX_LIMIT = 9;

	public static int throwDice() {
		return Randoms.pickNumberInRange(MIN_LIMIT, MAX_LIMIT);
	}
}
