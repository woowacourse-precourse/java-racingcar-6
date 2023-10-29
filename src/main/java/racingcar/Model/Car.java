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

		final int MAX_NAME_LENGTH = 5;

		if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
			throw new IllegalArgumentException("5자 이하의 이름있는 자동차만 넣을 수 있습니다.");
		}

	}

	public void moveOrStop() {

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

	public boolean isLaggingCar(Car other) {
		return this.distance < other.distance;
	}

	public String getStatus(String graphUnit) {
		return name + " : " + makeDistanceGraph(graphUnit);
	}

	private String makeDistanceGraph(String graphUnit) {
		return graphUnit.repeat(distance);
	}

	public String toString() {
		return name;
	}

}
