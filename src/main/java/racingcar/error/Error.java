package racingcar.error;

public enum Error {
	INVALID_CARNAME_LENGTH("자동차 이름은 5글자 이하만 가능합니다."),
	INVALID_NUMBER("숫자를 입력해주세요."),
	NUMBER_POSITIVE_ERROR("양수를 입력해주세요.");

	private String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
