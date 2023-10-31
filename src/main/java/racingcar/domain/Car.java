package racingcar.domain;

import java.util.stream.IntStream;

public class Car {

	private final CarName carName;
	private final CarLocation carLocation;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carLocation = new CarLocation();
	}
	
	public Car(String carName, int carLocation) {
		this.carName = new CarName(carName);
		this.carLocation = new CarLocation(carLocation);
	}
	
	public void move() {
		carLocation.increaseLocation();
	}

	public String printCarStatus() {
		return String.format("%s : %s", carName.getName(), convertCarLocationToMinus());
	}

	private String convertCarLocationToMinus() {
		StringBuilder strBuilder = new StringBuilder();

		IntStream.range(0, carLocation.getLocation()).forEach(x -> strBuilder.append("-"));

		return strBuilder.toString();
	}
	
	public String getCarName() {
		return carName.getName();
	}
	
	public int getCarLocation() {
		return carLocation.getLocation();
	}
}
