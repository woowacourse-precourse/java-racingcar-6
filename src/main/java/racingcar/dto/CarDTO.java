package racingcar.dto;

import racingcar.domain.Car;

public class CarDTO {
	Car car;
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(String carName, int carLocation) {
		car = new Car(carName, carLocation);
	}
}