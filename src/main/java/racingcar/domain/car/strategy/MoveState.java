package racingcar.domain.car.strategy;

public enum MoveState {
	FORWARD(1),
	STOP(0);

	private final int distance;

	MoveState(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}
}
