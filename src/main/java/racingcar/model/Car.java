package racingcar.model;

public class Car {
	private String name;
	private int forwardCount;
	private String forwardResult;

	public Car(String nm) {
		this.name = nm;
		this.forwardCount =0;
		this.forwardResult = "";
	}
	
	public String getName() {
		return this.name;
	}

	public int getForwardCount() {
		return this.forwardCount;
	}
	
	public void forward() {
		this.forwardCount++;
		this.forwardResult += "-";
	}
	
	public String getForwardResult() {
		return this.forwardResult;
	}
}
