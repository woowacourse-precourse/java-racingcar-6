package racingcar.domain;

import racingcar.util.message.ErrorMessage;

public class CarLocation {
	
	private final static int DEFAULT_VALUE = 0;
	
	private int location;
	
	public CarLocation() {
		this.location = DEFAULT_VALUE;
	}
	
	public CarLocation(int location) {
		validate(location);
		this.location = location;
	}
	
	private void validate(int location) {
		validateNegativeNumber(location);
	}
	
	private void validateNegativeNumber(int location) {
		if(location < 0) {
			throw new IllegalArgumentException(ErrorMessage.CAR_LOCATION_NEGATIVE_NUMBER.getMessage());
		}
	}
	
	public void increaseLocation() {
		location++;
	}
	
	public int getLocation() {
		return location;
	}
}
