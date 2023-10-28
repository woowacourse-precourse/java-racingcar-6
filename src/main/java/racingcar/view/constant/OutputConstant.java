package racingcar.view.constant;

public enum OutputConstant {
	SEPERATOR(" : "),
	FORWARD_MARK("-"),
	GAME_RESULT("\n실행 결과\n"),
	WINNER("최종 우승자 : "),
	WINNER_DELIMITER(", ");

	private final String requestMessage;

	OutputConstant(String value) {
		this.requestMessage = value;
	}

	public String getRequestMessage() {
		return requestMessage;
	}
}
