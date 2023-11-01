package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	String name;
	int distance = 0;

	public Car(String name) {
		this.name = name;
	}

	void moveForward() {
		int random = Randoms.pickNumberInRange(0, 9);
		if (random >= 4) {
			distance++;
		}
	}

	void showDistance() {
		String showDistance = name + " : ";

		for (int i = 0; i < distance; i++) {
			showDistance += "-";
		}

		System.out.println(showDistance);
	}

}
