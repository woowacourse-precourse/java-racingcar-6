package racingcar.Model;

public class Car {
	private final String name;
	private int distance;

	public Car(String name) {
		this.name = name;
		this.distance = 0;
	}

	public int getDistance() {
		return this.distance;
	}

	public String getName() {
		return this.name;
	}

	public void move() {
		this.distance++;
	}

	public int compareDistance(Car other) {
		return this.distance - other.distance;
	}

	public String makeDistanceGraph(String graphUnit) {

		String graph = "";

		for(int i = 0; i < distance; i++) {
			graph += graphUnit;
		}

		return graph;
	}

	public String toString() {
		return this.name;
	}

}
