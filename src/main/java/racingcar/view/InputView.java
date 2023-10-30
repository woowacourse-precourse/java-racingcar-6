package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

	private static final String DELIMITER = ",";

	public List<String> readCarNames() {
		String names = Console.readLine();
		return Arrays.asList(names.split(DELIMITER));
	}
}
