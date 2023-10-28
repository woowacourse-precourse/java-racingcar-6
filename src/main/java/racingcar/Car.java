package racingcar;

public class Car {
	private final String name;
	private int position;
	private final StringBuilder history;

	public Car(String name) {
		this.name = name;
		this.position = 0;
		this.history = new StringBuilder();
	}

	public void move() {
		position++;
		history.append("-");
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public StringBuilder getHistory() {
		return history;
	}

}
