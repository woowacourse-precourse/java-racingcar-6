package racingcar.exception;

public enum ErrorMessage {
	EMPTY_ERROR("입력을 하지 않았습니다."),
	LENGTH_ERROR(" -> 이름은 1 ~ 5 글자여야 합니다."),
	SPACE_ERROR(" -> 이름에 공백만 포함할 수 없습니다."),
	DUPLICATED_ERROR(" -> 중복된 이름을 입력할 수 없습니다."),
	NUMBER_ERROR(" -> 자연수만 입력 가능합니다."),
	RANGE_ERROR(" -> 게임은 1회 이상 시행되어야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
