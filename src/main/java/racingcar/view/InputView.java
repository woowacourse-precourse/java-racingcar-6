package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validators.InvalidInputValidators;

public class InputView {

	private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

	private final InvalidInputValidators invalidInputValidators = new InvalidInputValidators();

	public String[] getCarsName() {
		System.out.println(ASK_CAR_NAME);
		return userInput().split(",");
	}

	public int getNumberOfAttempts() {
		System.out.println(ASK_NUMBER_OF_ATTEMPTS);

		String input = userInput();

		invalidInputValidators.validateNumberOfAttempts(input);

		return Integer.parseInt(input);
	}

	public String userInput() {
		return Console.readLine();
	}
}