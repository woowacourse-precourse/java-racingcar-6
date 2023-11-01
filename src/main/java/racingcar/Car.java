package racingcar;

public class Car {
    String name;
	int advance = 0;
	
	public Car(String name) {
		this.name = name;
	}	
	public String getName() {
		return name;
	}
	public int getAdvance() {
		return advance;
	}
}
