package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void go() {
		if (Util.getRandomNum() >= Constants.GO_NUM) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
