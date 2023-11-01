package domain;

public class Car {
	private static final String HYPHEN = "-";
	private final String name;
	private int location;

	public Car(String name) {
		this.name = name;
		this.location = 0;
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

	public void moveByNumber(int randomNumber) {
		if (4 <= randomNumber && randomNumber <= 9) {
			move();
		}
	}

	public void move() {
		this.location += 1;
	}

	public String createHyphenByLocation() {
		return HYPHEN.repeat(this.location);
	}
}
