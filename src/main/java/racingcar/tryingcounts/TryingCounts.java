package racingcar.tryingcounts;

import racingcar.input.InputController;
import racingcar.validation.tryingcounts.TryingCountsNumberValidationChecker;

public class TryingCounts {

	InputController inputController = new InputController();
	TryingCountsNumberValidationChecker tryingCountsNumberValidationChecker = new TryingCountsNumberValidationChecker();

	public Integer getTryingCounts() {
		String tryingCounts = inputController.scanTryingCountsNumber();
		try {
			return tryingCountsNumberValidationChecker.checkTryingCountsNumberValidation(
				tryingCounts);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw illegalArgumentException;
		}
	}
}
