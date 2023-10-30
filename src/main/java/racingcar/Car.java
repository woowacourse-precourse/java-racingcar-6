package racingcar;

public class Car {
	private String name;
	private int moveCount;
	private static int CAR_MOVE_CONDITION = 4;

	public Car(String name) {
		this.name = name;
		this.moveCount = 0;
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void run(int value) {
		if (value >= CAR_MOVE_CONDITION) {
			moveCount++;
		}
	}
}
