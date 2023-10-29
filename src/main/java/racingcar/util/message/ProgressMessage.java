package racingcar.util.message;

public enum ProgressMessage {
	
	INPUT_CARNAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_TRY_NUMBER("시도할 회수는 몇회인가요? \n"),
	EXECUTION_RESULT("실행결과"),
	WINNER("최종 우승자 : %s");

	private final String message;

	ProgressMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
