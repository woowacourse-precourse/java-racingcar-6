package racingcar.view;

public class InputView {
	private static final String ASK_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASK_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	public static void askInputCarName() {
		System.out.println(ASK_CARNAME_MESSAGE);
	}

	public static void askTryNumber() {
		System.out.println(ASK_TRY_NUMBER_MESSAGE);
	}
}
