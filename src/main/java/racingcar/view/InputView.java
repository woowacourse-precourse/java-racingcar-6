package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.validator.Validator;

public class InputView {

	public String inputCarNames() {
		String inputValue = Console.readLine();

		inputCarNamesValidate(inputValue);

		return inputValue;
	}

	private void inputCarNamesValidate(String inputValue) {
		Validator.validateContainNumber(inputValue);
		Validator.validateOutOfLength(inputValue);
	}
}
