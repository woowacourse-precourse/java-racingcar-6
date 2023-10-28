package racingcar;

public class Validator {

	public Validator() {

	}
	public boolean validateNameLength(String carName) {
		if (carName.length() > 5 || carName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public int validateMoveCount(String moveCountString) {
		int moveCount = 0;
		try {
			moveCount = Integer.parseInt(moveCountString);
			validateNaturalNumber(moveCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		return moveCount;
	}

	private void validateNaturalNumber(int moveCount) {
		if (moveCount < 1) {
			throw new IllegalArgumentException();
		}
	}
}
