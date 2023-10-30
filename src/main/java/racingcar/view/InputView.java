package racingcar.view;

import racingcar.util.io.InputViewReader;
import racingcar.util.validator.Validator;

public class InputView {
	
	private static final InputViewReader READER = new InputViewReader();
	
	public String inputCarNames() {
		String inputValue = READER.readLine();

		inputCarNamesValidate(inputValue);

		return inputValue;
	}

	public int inputTryNumber() {
		String inputValue = READER.readLine();
		
		inputTryNumberValidate(inputValue);
		
		return Integer.parseInt(inputValue);
	}

	private void inputCarNamesValidate(String inputValue) {
		Validator.validateContainNumber(inputValue);
		Validator.validateOutOfLength(inputValue);
	}
	
	private void inputTryNumberValidate(String inputValue) {
		Validator.validateNumberFormat(inputValue);
	}
}
