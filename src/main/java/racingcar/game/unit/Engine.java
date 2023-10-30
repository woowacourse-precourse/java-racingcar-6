package racingcar.game.unit;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {

	public static Engine newEngine() {
		return new Engine();
	}

	private Engine() {
	}

	public int activate() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
