package racingcar.model;

import static racingcar.utils.GameConstants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void moveCar() {
		int carMoveNum = Randoms.pickNumberInRange(0, 9);
		if (carMoveNum >= 4) {
			position += 1;
		}
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}

	public boolean isWinner(Integer maxDistance) {
		return position == maxDistance;
	}
}
