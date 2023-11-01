package racingcar.domain;

class Car {
	private final String name;
	private int position = 0;

	Car(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	int getPosition() {
		return position;
	}

	void moveForward(int number) {
		if (number >= 4) {
			position += 1;
		}
	}
}
