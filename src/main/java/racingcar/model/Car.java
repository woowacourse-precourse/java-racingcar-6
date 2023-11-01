package racingcar.model;

public class Car {
	private final String name;
	
	private static final int MAX_CARNAME_LENGTH = 5;
	private static final int MIN_CARNAME_LENGTH = 1;
		
	public Car(String name) {
		vallidateNameLength(name);
		this.name = name;
	}
	
	private void vallidateNameLength(String name) {
		if(name.length() > MAX_CARNAME_LENGTH || 
				name.length() < MIN_CARNAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
		}
	}
}
