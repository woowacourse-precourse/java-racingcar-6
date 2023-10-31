package domain;

public class Car {
	private String name;
	private int location;

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
}
