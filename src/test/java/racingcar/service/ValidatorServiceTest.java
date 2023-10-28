package racingcar.service;

import racingcar.domain.enums.ValidationMsg;

public class ValidatorServiceTest {
	private ValidatorService validatorService;

	private ValidatorServiceTest() {
		this.validatorService = ValidatorService.getInstance();
	}

	private static class ValidatorServiceImplTestHolder {
		private static final ValidatorServiceTest VALIDATOR_SERVICE_IMPL_TEST = new ValidatorServiceTest();
	}

	public static ValidatorServiceTest getInstance() {
		return ValidatorServiceImplTestHolder.VALIDATOR_SERVICE_IMPL_TEST;
	}

	public ValidationMsg validationCarName(String carName) {
		return validatorService.validationCarName(carName);
	}
	public ValidationMsg validationCarRaceTimes(String carName) {
		return validatorService.validationCarRaceTimes(carName);
	}
}
