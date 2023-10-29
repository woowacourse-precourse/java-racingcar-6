package racingcar;

public class InformationOfCar {

	private String carName;
	private String distance;

	public InformationOfCar(String carName, String distance) {
		this.carName = carName;
		this.distance = distance;
	}

	public String getCarName() {
		return carName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance += distance;
	}
}
