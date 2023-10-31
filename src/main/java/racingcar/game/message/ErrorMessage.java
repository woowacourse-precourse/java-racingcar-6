package racingcar.game.message;

public enum ErrorMessage {

	CAR_NAME_NOT_LONGER_THAN_5("자동차 이름은 5자 이하만 가능합니다."),
	CAR_NAME_NOT_BLANK("자동차 이름은 공백이 될 수 없습니다."),

	ATTEMPT_NOT_LESS_THAN_0("시도 횟수는 0 이상이어야 합니다.")
	;

	private String message;

	public String getMessage() {
		return message;
	}

	ErrorMessage(String message) {
		this.message = message;
	}
}
