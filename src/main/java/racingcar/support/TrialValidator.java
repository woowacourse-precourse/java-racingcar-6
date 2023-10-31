package racingcar.support;

public class TrialValidator {

	private static final int MIN_TRIAL_LENGTH = 1;

	private TrialValidator() {
		throw new IllegalStateException();
	}

	public static void validate(String trial) {
		validateToNumber(trial);
		validateRange(trial);
	}

	private static void validateToNumber(String trial) {
		try {
			Integer.parseInt(trial);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도는 숫자로 입력해야 합니다.");
		}
	}

	private static void validateRange(String trial) {
		if (Integer.parseInt(trial) < MIN_TRIAL_LENGTH) {
			throw new IllegalArgumentException("시도는 1 이상으로 입력해야 합니다.");
		}
	}
}
