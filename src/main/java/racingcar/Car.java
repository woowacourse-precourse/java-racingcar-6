package racingcar;

public class Car {

	private final String name;
	private int position;

	public Car(String name) {
		checkNameLength(name);
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void move(int randomNumber) {
		if (isMovable(randomNumber)) {
			this.position++;
		}
	}

	public String getPositionString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.name);
		stringBuilder.append(" : ");
		for (int i = 0; i < this.position; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}

	private boolean isMovable(int randomNumber) {
		return randomNumber >= 4;
	}

	private void checkNameLength(String name) throws IllegalArgumentException {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
	}

}