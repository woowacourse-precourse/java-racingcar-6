package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final String NAME;
	private int distance;

	public Car(String inputName) {

		String name = inputName.trim();

		validateName(name);
		this.NAME = name;
		this.distance = 0;
	}

	public void validateName(String name) {

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
		return NAME + " : " + makeDistanceGraph(graphUnit);
	}

	private String makeDistanceGraph(String graphUnit) {
		return graphUnit.repeat(distance);
	}

	public String toString() {
		return NAME;
	}

}
