package racingcar.domain;

public class Car {
	private String name;
	StringBuilder distance = new StringBuilder();

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public StringBuilder getDistance() {
		return distance;
	}
}
