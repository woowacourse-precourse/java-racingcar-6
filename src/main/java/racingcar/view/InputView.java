package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.support.DividedCarNamesValidator;
import racingcar.support.TrialValidator;

public class InputView {

	private InputView() {
		throw new IllegalStateException();
	}

	private static final String DELIMITER = ",";

	public static List<String> readCarNames() {
		String names = Console.readLine();
		String[] dividedCarNames = names.split(DELIMITER);
		DividedCarNamesValidator.validate(dividedCarNames);
		return Arrays.asList(dividedCarNames);
	}

	public static int readTrial() {
		String trial = Console.readLine();
		TrialValidator.validate(trial);
		return Integer.parseInt(trial);
	}
}
