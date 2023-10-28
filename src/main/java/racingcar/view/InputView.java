package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;
import racingcar.view.constant.InputConstant;

public class InputView {
	public void printNamesRequest() {
		System.out.println(InputConstant.NAMES_REQUEST.getRequestMessage());
	}

	public void printRoundRequest() {
		System.out.println(InputConstant.ROUND_REQUEST.getRequestMessage());
	}

	public String getInput() {
		String input = Console.readLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR.getMessage());
		}
		return input;
	}
}
