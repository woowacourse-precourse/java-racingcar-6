package racingcar.exception;

public class InputNameException {
	static final int NAME_LENGTH = 5;

	public void checkLength(String input) {
		if (input.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}
	}

	public void checkException(String[] input) {
		for (int i=0; i<input.length; i++) {
			checkLength(input[i]);
		}
	}
}