package racingcar.view;

public class InputView {
	final static String MESSAGE_CAR_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	final static String MESSAGE_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

	public static void printCarList() {
		System.out.println(MESSAGE_CAR_LIST);
	}

	public static void printAttemptCount() {
		System.out.println(MESSAGE_ATTEMPT_COUNT);
	}

}
