package racingcar.domain;

public class TryNumber {
	private Integer tryNumber;

	public TryNumber(String input) {
		NumberValidator.validate(input);
		this.tryNumber = Integer.parseInt(input);
	}

	public boolean isTryable() {
		return tryNumber > 0;
	}

	public void decrease() {
		tryNumber--;
	}
}
