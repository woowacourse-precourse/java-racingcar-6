package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {
	private String name;
	private int position;
	static final int moveValue = 4;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move() {
		int move = Randoms.pickNumberInRange(0, 9);
		if (move >= moveValue) {
			position++;
		}
	}

}
