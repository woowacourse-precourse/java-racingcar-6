package racingcar;

//검증 클래스
public class Validator {
	private static final int MAXINUM_LENGTH = 5;
	private static final int MININUM_NUMBER = 1;

	public Validator() {

	}

	public boolean validateNameLength(String carName) {
		if (carName.length() > MAXINUM_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public void validateEmptyString(boolean isExist) {
		if (!isExist) {
			throw new IllegalArgumentException();
		}
	}

	public boolean validateSpace(String carName) {
		carName = carName.replace(" ", "");
		if (carName.equals("")) {
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
