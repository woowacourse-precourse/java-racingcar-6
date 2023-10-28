package racingcar.view.constant;

public enum InputConstant {
	INPUT_DELIMITER(","),
	NAMES_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ROUND_REQUEST("시도할 회수는 몇회인가요?");

	private final String requestMessage;

	InputConstant(String value) {
		this.requestMessage = value;
	}

	public String getRequestMessage() {
		return requestMessage;
	}
}
