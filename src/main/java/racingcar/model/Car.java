package racingcar.model;

public class Car {
	private String name;
	private String ForwardCount;

	public Car(String nm) {
		this.name = nm;
		this.ForwardCount = "";
	}
	
	public String getName() {
		return this.name;
	}

	public String getForwardCount() {
		return this.ForwardCount;
	}
	
	public void forward() {
		this.ForwardCount += "-";
	}
}
