package racingcar.service;

import racingcar.domain.enums.NumberTypeGameRule;
import racingcar.domain.enums.ValidationMsg;

import java.util.HashSet;
import java.util.Set;

public class ValidatorService {
	private StringUtilService stringUtilService = StringUtilService.getInstance();
	private ValidatorService() {
	}
	private static class ValidatorServiceHolder {
		private static final ValidatorService VALIDATOR_SERVICE = new ValidatorService();
	}
	public static ValidatorService getInstance() {
		return ValidatorServiceHolder.VALIDATOR_SERVICE;
	}

	public ValidationMsg validationCarName(String carName) {
		if (carName == null) throw new IllegalArgumentException(String.valueOf(ValidationMsg.NULL_TYPE));
		if (carName.isEmpty()) throw new IllegalArgumentException(String.valueOf(ValidationMsg.EMPTY_TYPE));
		if (!this.isPassCarNameLength(carName)) {
			throw new IllegalArgumentException(String.valueOf(ValidationMsg.CAR_NAME_OVER_FIVE));
		}
		if (this.isDuplicateUserInput(carName)) {
			throw new IllegalArgumentException(String.valueOf(ValidationMsg.NOT_DUPLICATE_NAME));
		}

		return ValidationMsg.PROPER_TYPE;
	}


	private boolean isPassCarNameLength(String carName) {
		for (String eachCar : stringUtilService.splitByComma(carName)) {
			if (eachCar.length() > NumberTypeGameRule.MAX_CAR_NAME_LENGTH.getValue()) return false;
		}
		return true;
	}
	// 중복 입력된 값이 있는지 체크
	public boolean isDuplicateUserInput(String userInput) {
		String[] arrUserInput = userInput.split(",");
		Set<String> userInputSet = new HashSet<>();
		for (String userInputNum : arrUserInput) {
			userInputSet.add(userInputNum.trim());
		}
		return (arrUserInput.length != userInputSet.size());
	}
	public ValidationMsg validationCarRaceTimes(String RaceTimes) {
		if (RaceTimes == null) throw new IllegalArgumentException(String.valueOf(ValidationMsg.NULL_TYPE));
		if (RaceTimes.isEmpty()) throw new IllegalArgumentException(String.valueOf(ValidationMsg.EMPTY_TYPE));
		try {
			Integer.valueOf(RaceTimes);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.valueOf(ValidationMsg.NOT_NUMBER));
		}
		if (RaceTimes.equals("0")) throw new IllegalArgumentException(String.valueOf(ValidationMsg.ZERO_TYPE));

		return ValidationMsg.PROPER_TYPE;
	}
}
