package racingcar.util.message;

public enum ErrorMessage {

	CAR_NAME_LENGTH_ERROR("차 이름의 길이는 5이하여야 합니다."),
	CONTAIN_NUMBER_ERROR("숫자가 아닌 문자만 입력가능합니다."),
	PREFIX("[ERROR] ");

	private final String message;	

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}
