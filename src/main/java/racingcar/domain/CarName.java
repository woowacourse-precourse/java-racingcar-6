package racingcar.domain;

import java.util.regex.Pattern;

import racingcar.util.message.ErrorMessage;

public class CarName {
	
	private static final int LENGTH_LIMIT = 5;
	private static final Pattern CONTAIN_NUMBER_PATTERN = Pattern.compile(".*[0-9].*");
	
	private final String name;
	
	public CarName(String name) {
		validate(name);
		this.name = name;
	}
	
	private void validate(String name) {
		validateOutOfLength(name);
		validateContainNumber(name);
	}
	
	private static void validateOutOfLength(String name) {
		if (name.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
		}
	}
	
	private static void validateContainNumber(String name) {
		if (CONTAIN_NUMBER_PATTERN.matcher(name).matches()) {
			throw new IllegalArgumentException(ErrorMessage.CONTAIN_NUMBER_ERROR.getMessage());
		}
	}
	
	public String getName() {
		return name;
	}
}
