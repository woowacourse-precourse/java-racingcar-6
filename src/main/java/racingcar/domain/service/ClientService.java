package racingcar.domain.service;

import static racingcar.global.utils.constant.OutputType.EXCEPTION;

import java.util.Arrays;
import java.util.List;
import racingcar.global.utils.console.ConsoleUtil;

public class ClientService {
	private static final String SPLITTER = ",";

	public List<String> getCarsName() {
		String input = ConsoleUtil.input();
		return Arrays.stream(input.split(SPLITTER))
				.toList();
	}

	public int getNumberOfAttempt() {
		String input = ConsoleUtil.input();
		try {
			int numberOfAttempt = Integer.parseInt(input);
			validateNumberOfAttempt(numberOfAttempt);
			return numberOfAttempt;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(EXCEPTION.getComment());
		}
	}

	private void validateNumberOfAttempt(int numberOfAttempt) {
		if (numberOfAttempt < 0) {
			throw new IllegalArgumentException(EXCEPTION.getComment());
		}
	}
}
