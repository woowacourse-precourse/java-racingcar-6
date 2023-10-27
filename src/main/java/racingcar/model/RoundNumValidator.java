package racingcar.model;

import racingcar.Constants;

public class RoundNumValidator {
	public final String roundInput;

	public RoundNumValidator(String roundNumString) {
		this.roundInput = roundNumString;
		validate();
	}

	public void validate() {
		if (!isNumber() || !isPositiveNum()) {
			throw new IllegalArgumentException();
		}
	}
	public boolean isNumber() {
		return Constants.roundNumPattern.matcher(roundInput).matches();
	}

	public boolean isPositiveNum() {
		return Integer.parseInt(roundInput) > 0;
	}
}
