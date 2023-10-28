package racingcar.view;

import static racingcar.exception.ErrorMessage.*;
import static racingcar.view.constant.InputConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public void printNamesRequest() {
		System.out.println(NAMES_REQUEST.getRequestMessage());
	}

	public void printRoundRequest() {
		System.out.println(ROUND_REQUEST.getRequestMessage());
	}

	public String getInput() {
		String input = Console.readLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
		}
		return input;
	}
}
