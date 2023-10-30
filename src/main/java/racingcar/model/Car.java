package racingcar.model;

public class Car {
	private String name;
	private int ForwardCount;

	public Car(String nm) {
		this.name = nm;
		this.ForwardCount = 0;
	}

	public int getForwardCount() {
		return this.ForwardCount;
	}

}
