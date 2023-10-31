package model;

import racingcar.Constants;
import racingcar.Util;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		if (Util.getRandomNum() >= Constants.MOVE_NUM) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(int winDistance) {
		return position == winDistance;
	}

	public String getRoundResult() {
		return name + Constants.ROUND_RESULT_DELIMITER + Util.repeatDash(position);
	}

	public String getName() {
		return name;
	}
}
