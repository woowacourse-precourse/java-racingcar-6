package racingcar;

import java.util.Objects;

public class Car {
	String name;
	int moveCount;

	public Car(String name, int moveCount) {
		this.name = name;
		this.moveCount = moveCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car car)) {
			return false;
		}
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public void increaseMoveCount() {
		moveCount++;
	}
}

