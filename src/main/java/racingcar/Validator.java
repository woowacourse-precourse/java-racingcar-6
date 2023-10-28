package racingcar;

public class Validator {

	public Validator() {

	}
	public boolean validateNameLength(String carName) {
		if (carName.length() > 5 || carName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}
