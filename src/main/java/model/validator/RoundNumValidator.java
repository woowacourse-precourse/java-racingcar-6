package model.validator;

import exception.ErrorMessage;
import racingcar.Constants;

public class RoundNumValidator {
	public final String roundNumString;

	public RoundNumValidator(String roundNumString) {
		this.roundNumString = roundNumString;
		validate();
	}

	public void validate() {
		validateRoundNum();
	}

	private void validateRoundNum() {
		if (!Constants.roundNumPattern.matcher(roundNumString).matches()) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_ROUND_NUM);
		}
	}
}
