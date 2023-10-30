package racingcar;

public class Car {
	private final String name;
	private int moveCount;

	public Car(String name) {
		this.name = name;
		this.moveCount = 0;
	}

	public void move(boolean movable) {
		if (movable) {
			this.moveCount++;
		}
	}

	public String getName() {
		return name;
	}

	public int getStep() {
		return moveCount;
	}
}
