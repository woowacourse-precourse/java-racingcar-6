package racingcar.domain;

public class Car {

	private String carName;
	private int carLocation;

	public Car(String carName) {
		this.carName = carName;
		this.carLocation = 0;
	}

	public void move() {
		carLocation++;
	}

	public String getCarName() {
		return carName;
	}

	public int getCarLocation() {
		return carLocation;
	}

}
