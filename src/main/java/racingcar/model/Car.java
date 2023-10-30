package racingcar.model;

public class Car {

	private final String NAME;
	private int distance;

	public Car(String inputName) {

		String name = inputName.trim();

		validateName(name);
		this.NAME = name;
		this.distance = 0;
	}

	private void validateName(String name) {

		final int MAX_NAME_LENGTH = 5;

		if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
			throw new IllegalArgumentException("5자 이하의 이름있는 자동차만 넣을 수 있습니다.");
		}

	}

	public void moveOrStop(int randomNumber) {

		final int MOVE_DECISION_SIGN = 4;

		if (randomNumber >= MOVE_DECISION_SIGN) {
			this.distance++;
		}

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

	public int getDistance() {
		return this.distance;
	}

	public String toString() {
		return NAME;
	}

}
