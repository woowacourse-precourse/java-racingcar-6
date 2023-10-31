package racingcar.dto;

import racingcar.domain.Car;

public class CarDTO {
	Car car = new Car();
	
	public String getCarName() {
		return car.getCarName();
	}
	
	public int getCarLocation() {
		return car.getCarLocation();
	}
	
	public void setCar(String carName, int carLocation) {
		car.setCar(carName, carLocation);
	}
	
	public void setCarLocation(int carLocation) {
		car.setCarLocation(carLocation);
	}
	
	public void carMoveOrStop() {
		car.moveOrStop();
	}
}