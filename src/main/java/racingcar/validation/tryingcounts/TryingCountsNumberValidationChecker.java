package racingcar.validation.tryingcounts;

public class TryingCountsNumberValidationChecker {

	public Integer checkTryingCountsNumberValidation(String tryingCounts) {
		try {
			return Integer.parseInt(tryingCounts);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
