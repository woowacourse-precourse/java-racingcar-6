package racingcar;

public class Car {

	private int position;
	private final MovingStrategy movingStrategy;

	public Car(MovingStrategy movingStrategy) {
		this.position = 0;
		this.movingStrategy = movingStrategy;
	}

	public void move() {
		if (movingStrategy.canMove()) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
