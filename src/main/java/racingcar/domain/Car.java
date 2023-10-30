package racingcar.domain;

public class Car {
	private static final int MOVE_STANDARD = 4;
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}

	public void race(Car car) {
		if (isMovable(getRandomNumber())) {
			car.position.move();
		}
	}

	private int getRandomNumber() {
		return RandomNumberFactory.createRandomNumber();
	}

	private boolean isMovable (int number) {
		return number >= MOVE_STANDARD;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return position.getPosition();
	}
}
