package domain;

public class TryCountInput {

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
