package racingcar.dto.request;

public class CarNameReq {

	String carName;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void clear() {
		this.carName = "";
	}
}
