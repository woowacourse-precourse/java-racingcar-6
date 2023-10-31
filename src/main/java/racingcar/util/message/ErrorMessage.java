package racingcar.util.message;

public enum ErrorMessage {

	CAR_NAME_LENGTH_ERROR("차 이름의 길이는 5이하여야 합니다."),
	CONTAIN_NUMBER_ERROR("숫자가 아닌 문자만 입력가능합니다."),
	INPUT_LETTER_ERROR("문자가 아닌 숫자만 입력해야합니다."),
	CAR_LOCATION_NEGATIVE_NUMBER_ERROR("음수가 아닌 0또는 양의 정수를 입력해야합니다."),
	INPUT_EMPTY_ERROR("값을 입력해주세요."),
	PREFIX("[ERROR] ");

	private final String message;	

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}
