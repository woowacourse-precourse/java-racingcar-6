package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class InputView {

	public InputView() {
	}

	public static String inputCarNames() {
		System.out.println(Message.CAR_NAME_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String inputAttemptCount() {
		System.out.println(Message.ATTEMPT_COUNT_MESSAGE);
		return Console.readLine();
	}
}
