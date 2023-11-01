package racingcar.model;

public class Cars {
	private final String name;
	private int position = 0;

	public Cars(String name) {
		this.name = name;
	}

	public void moveForward(int distance) {
		position += distance;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
