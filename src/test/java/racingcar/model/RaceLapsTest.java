package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.util.Validator;

public class RaceLapsTest {
	@Test
	void parsableTryNumberToInteger() {
		String input = "#";
		assertThatThrownBy(() ->
			Validator.parsableToNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void tryNumberIsOverZero() {
		int input = 0;
		assertThatThrownBy(() ->
			Validator.numberIsOverZero(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
