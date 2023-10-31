package racingcar;

public class Car {
	private final String name;
	private int moveCount;

	public Car(String name) {
		validateNameLength(name);
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

	private void validateNameLength(String name) {
		final int maxLength = 5;
		final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 1자 이상 5자 이하로 입력해 주세요.";

		if (maxLength < name.length() || name.isEmpty()) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}
}
