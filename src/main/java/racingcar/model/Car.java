package racingcar.model;

public class Car {
	String name;
	int count;

	public Car(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void setCountPlus() {
		this.count++;
	}
}
