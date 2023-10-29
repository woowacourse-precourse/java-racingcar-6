package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;
import racingcar.util.InputValidator;
import racingcar.util.Message;

import java.util.List;
import java.util.Arrays;

public class InputView {
	public static List<String> inputCarName() {
		OutputView.printMessage(Message.INPUT_CAR_NAME_MESSAGE);
		String userInput = Console.readLine();

		List<String> carNames = Arrays.asList(userInput.split(Constant.INPUT_NAME_DELIMITER));
		InputValidator inputValidator = new InputValidator();

		for (String carName : carNames) {
			inputValidator.isValidName(carName);
		}

		return carNames;
	}

	public static int inputRoundNumber() {
		OutputView.printMessage(Message.INPUT_ROUND_NUMBER_MESSAGE);
		String userInput = Console.readLine();

		InputValidator inputValidator = new InputValidator();
		inputValidator.isValidRoundNumber(userInput);

		return Integer.parseInt(userInput);
	}
}
