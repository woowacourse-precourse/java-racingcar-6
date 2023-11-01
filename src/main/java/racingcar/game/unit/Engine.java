package racingcar.game.unit;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {

	private static final int MAX_POWER = 9;
	private static final int MIN_POWER = 0;

	public static Engine newEngine() {
		return new Engine();
	}

	private Engine() {
	}

	public int activate() {
		return Randoms.pickNumberInRange(MIN_POWER, MAX_POWER);
	}
}
