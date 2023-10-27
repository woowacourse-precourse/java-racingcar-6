package racingcar.domain;

public class Car {
	String carName;
	int carLocation;
	
	public String getCarName() {
		return carName;
	}
	
	public int getCarLocation() {
		return carLocation;
	}
	
	public void setCar(String carName, int carLocation) {
		this.carName = carName;
		this.carLocation = carLocation;
	}
	
	public void setCarLocation(int carLocation) {
		this.carLocation = carLocation;
	}
}