package racingcar;

public class Name {

	private static final int MAX_LENGTH = 5;
	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		validateNull(name);
		validateLength(name);

	}

	private void validateLength(String input) {
		if (input.length() > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	private void validateNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return name;
	}

}
