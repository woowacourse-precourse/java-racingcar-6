package racingcar.domain.service;

import static racingcar.global.utils.constant.OutputType.EXCEPTION;

import java.util.Arrays;
import java.util.List;
import racingcar.global.utils.console.ConsoleUtil;

public class ClientService {

	private static final int MAX_LENGTH_OF_CAR_NAME = 5;
	private static final int MIN_LENGTH_OF_CAR_NAME = 0;
	private static final String SPLITTER = ",";

	public List<String> getCarsName() {
		String input = ConsoleUtil.input();
		return Arrays.stream(input.split(SPLITTER))
				.peek(this::validateCarName)
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

	private void validateCarName(String carName) {
		if (isInValidCarNameLength(carName)) {
			throw new IllegalArgumentException(EXCEPTION.getComment());
		}
	}

	private boolean isInValidCarNameLength(String carName) {
		return carName.length() > MAX_LENGTH_OF_CAR_NAME || carName.length() == MIN_LENGTH_OF_CAR_NAME;
	}

	private void validateNumberOfAttempt(int numberOfAttempt) {
		if (numberOfAttempt < 0) {
			throw new IllegalArgumentException(EXCEPTION.getComment());
		}
	}
}
