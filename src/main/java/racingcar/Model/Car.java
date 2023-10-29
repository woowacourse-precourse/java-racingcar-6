package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int distance;

	public Car(String name) {
		this.name = name.trim();
		this.distance = 0;
	}

	public void validateName() {
		if(name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	public void move() {
		final int MOVE_DECISION_SIGN = 4;

		int randomNumber = makeRandomNumber();

		if (randomNumber >= MOVE_DECISION_SIGN) {
			this.distance++;
		}

	}

	private int makeRandomNumber() {
		final int MIN_NUMBER = 0;
		final int MAX_NUMBER = 9;

		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	public int compareDistance(Car other) {
		return this.distance - other.distance;
	}

	public String checkStatus(String graphUnit) {

		StringBuilder status = new StringBuilder();
		status.append(name).append(" : ").append(makeDistanceGraph(graphUnit));

		return status.toString();
	}

	private String makeDistanceGraph(String graphUnit) {
		return graphUnit.repeat(distance);
	}

	public String toString() {
		return name;
	}

}
