package racingcar.view.constant;

public enum OutputConstant {
	SEPERATOR(" : "),
	FORWARD_MARK("-"),
	GAME_RESULT("\n실행 결과\n"),
	WINNER("최종 우승자 : "),
	WINNER_DELIMITER(", ");

	private final String value;

	OutputConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
