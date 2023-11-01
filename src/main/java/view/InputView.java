package view;

public class InputView {
	private static final String INPUT_START = "경주할 자동차 이름을 입력하세요.(이름은  쉼표(,) 기준으로 구분)";
	private static final String INPUT_ATTEMPT = "시도할 회수는 몇회인가요?";

	public void printCarNameInputMessage() {
		System.out.println(INPUT_START);
	}

	public void printAttemptNumberInputMessage() {
		System.out.println(INPUT_ATTEMPT);
	}
}