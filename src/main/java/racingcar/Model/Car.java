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
		final int MIN_NUMBER = 0;
		final int MAX_NUMBER = 9;

		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
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

		final String NAME_SEPARATOR = ", ";

		return this.name + NAME_SEPARATOR + other.name;
	}

	public String toString() {
		return this.name;
	}

}
