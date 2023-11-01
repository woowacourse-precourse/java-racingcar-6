package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	static final int MIN_RANDOM_NUMBER = 0;
	static final int MAX_RANDOM_NUMBER = 9;

	private String name;
	private int distance = 0;

	public Car(String name) {
		this.name = name;
	}

	void moveForward() {
		int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
		if (random >= 4) {
			distance++;
		}
		showDistance();
	}

	void showDistance() {
		StringBuilder showDistance = new StringBuilder();

		showDistance.append(name + " : ").append("-".repeat(distance));

		System.out.println(showDistance);
	}

	public int getDistance() {
		return this.distance;
	}

	public String getName() {
		return name;
	}
}
