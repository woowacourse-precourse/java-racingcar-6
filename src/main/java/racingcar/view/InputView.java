package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.support.DividedCarNamesValidator;

public class InputView {

	private static final String DELIMITER = ",";

	public List<String> readCarNames() {
		String names = Console.readLine();
		String[] dividedCarNames = names.split(DELIMITER);
		DividedCarNamesValidator.validate(dividedCarNames);
		return Arrays.asList(dividedCarNames);
	}
}
