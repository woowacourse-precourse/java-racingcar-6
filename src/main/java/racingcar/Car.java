package racingcar;

public class Car {
	private String carName;
	private int carCount;

	public Car(String carName) {
		super();
		this.carName = carName;
		this.carCount = 0;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarCount() {
		return carCount;
	}

	public void setCarCount(int carCount) {
		this.carCount = carCount;
	}

	@Override
	public String toString() {
		return carName + " : " + printCount();
	}
	
	private String printCount() {
		String str = "";
		
		for (int i = 0;i < this.getCarCount();i++) {
			str += "-";
		}
		
		return str;
	}

}
