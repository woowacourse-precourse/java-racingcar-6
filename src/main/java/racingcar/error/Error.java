package racingcar.error;

public enum Error {
	INVALID_CARNAME_LENGTH("자동차 이름은 5글자 이하만 가능합니다.");

	private String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
