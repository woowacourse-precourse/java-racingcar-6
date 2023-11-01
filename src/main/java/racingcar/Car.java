package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private String name;
	private int position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void move() {

		int ran = Randoms.pickNumberInRange(0, 9);

		if (ran >= 4) {
			position++;
		}
	}
}
