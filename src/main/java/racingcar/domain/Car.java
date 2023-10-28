package racingcar.domain;

import java.util.stream.IntStream;

public class Car {

	private String carName;
	private int carLocation;

	public Car(String carName) {
		this.carName = carName;
		this.carLocation = 0;
	}
	
	public Car(String carName, int carLocation) {
		this.carName = carName;
		this.carLocation = carLocation;
	}
	
	public void move() {
		carLocation++;
	}

	public String printCarStatus() {
		return String.format("%s : %s", carName, convertCarLocationToMinusWords());
	}

	private String convertCarLocationToMinusWords() {
		StringBuilder strBuilder = new StringBuilder();

		IntStream.range(0, carLocation).forEach(x -> strBuilder.append("-"));

		return strBuilder.toString();
	}

	public String getCarName() {
		return carName;
	}
	
	public int getCarLocation() {
		return carLocation;
	}
}
