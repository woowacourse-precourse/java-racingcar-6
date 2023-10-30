package racingcar.game.unit;

public class Car {

	private String name;
	private Engine engine;
	private int position;

	public static Car of(String name) {
		checkValidCarName(name);
		return new Car(
				name,
				0,
				Engine.newEngine());
	}

	private Car(String name, int position, Engine engine) {
		this.name = name;
		this.position = position;
		this.engine = engine;
	}

	private static void checkValidCarName(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		if (carName.isBlank()) {
			throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
		}
	}

	public void startEngine() {
		int power = engine.activate();
		if (power >= 4) {
			moveForward();
		}
	}

	private void moveForward() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}