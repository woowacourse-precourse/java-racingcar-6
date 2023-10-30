package racingcar;

public class Validator {
	private static final int MAXINUM_LENGTH = 5;
	private static final int MININUM_NUMBER = 1;
	public Validator() {

	}
	public boolean validateNameLength(String carName) {
		if (carName.length() > MAXINUM_LENGTH || carName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public boolean validateEmptyString(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public boolean validateSpace(String carName) {
		if (carName.equals(" ")) {
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
		if (moveCount < MININUM_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}
