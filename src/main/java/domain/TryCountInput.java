package domain;

public class TryCountInput {
	private final int tryCount;

	public TryCountInput(String stringTryCount) {
		int parseTryCount = validateAndParseInteger(stringTryCount);
		validatePositive(parseTryCount);

		this.tryCount = parseTryCount;
	}

	public int getTryCount() {
		return tryCount;
	}

	public void validatePositive(int tryCount) {
		if (tryCount <= 0) {
			throw new IllegalArgumentException();
		}
	}

	public int validateAndParseInteger(String inputTryCount) {
		try {
			return Integer.parseInt(inputTryCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
