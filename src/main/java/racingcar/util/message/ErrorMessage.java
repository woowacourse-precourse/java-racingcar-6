package racingcar.util.message;

public enum ErrorMessage {

	CAR_NAME_LENGTH_ERROR("차 이름의 길이는 5이하여야 합니다."),
	PREFIX("[ERROR] ");

	private final String message;	

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}
