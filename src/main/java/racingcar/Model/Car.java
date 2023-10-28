package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int distance;

	public Car(String name) {
		this.name = name;
		this.distance = 0;
	}

	public int getDistance() {
		return this.distance;
	}

	public String getName() {

		return this.name;
	}

	private int makeRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

	public void move() {
		final int MOVE_DECISION_SIGN = 4;

		int randomNumber = makeRandomNumber();

		if (randomNumber >= MOVE_DECISION_SIGN) {
			this.distance++;
		}

	}

	public int compareDistance(Car other) {
		return this.distance - other.distance;
	}

	public String makeDistanceGraph(String graphUnit) {

		String graph = "";

		for (int i = 0; i < distance; i++) {
			graph += graphUnit;
		}

		return graph;
	}

	public String joinName(Car other) {
		return this.name + ", " + other.name;
	}

	public String toString() {
		return this.name;
	}

}
