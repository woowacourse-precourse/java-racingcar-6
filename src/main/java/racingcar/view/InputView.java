package racingcar.view;

import static racingcar.utils.GameConstants.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.GameCountValidator;

public class InputView {
	public static String[] inputCarName() {
		while (true) {
			
			System.out.println(INPUT_CAR_NAME_MESSAGE);
			String carNameInput = Console.readLine();
			try {
				CarNameValidator.checkCarNameInput(carNameInput);
				String[] carNamesList = carNameInput.split(",");
				CarNameValidator.checkCarNames(carNamesList);
				return carNamesList;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static Integer inputGameCount() {
		while (true) {
			System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
			String gameCount = Console.readLine();
			try {
				GameCountValidator.checkGameCount(gameCount);
				return Integer.parseInt(gameCount);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}
}
