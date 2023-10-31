package racingcar.util;

public class Validator {
	public void validateName(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public void validateCount(String count) {
		try {
			Integer.parseInt(count);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException();
		}
	}
}