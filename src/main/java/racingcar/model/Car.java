package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

public class Car {
	private final String name;
	private int position = 0;
	int random = 0;

	public Car(String name) {
		this.name = name;
	}

	public void go() {
		random = Util.getRandomNum();
		if (random >= Constants.GO_NUM) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public int getRandom() {
		return random;
	}
}
