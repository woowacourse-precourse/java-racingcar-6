package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;
import racingcar.util.Message;

import java.util.List;
import java.util.Arrays;

public class InputView {
	public static List<String> inputCarName() {
		OutputView.printMessage(Message.INPUT_CAR_NAME_MESSAGE);
		String userInput = Console.readLine();

		return Arrays.asList(userInput.split(Constant.INPUT_NAME_DELIMITER));
	}

	public static int inputTryNumber() {
		OutputView.printMessage(Message.INPUT_TRY_NUMBER_MESSAGE);
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}
}
