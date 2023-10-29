package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.error.Error.*;

import org.junit.jupiter.api.Test;

public class TryNumberTest {
	@Test
	void 시도횟수가_숫자가_아니면_예외를_발생시킨다() {
		String input = "예외";

		assertThatThrownBy(() -> new TryNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(INVALID_NUMBER.getMessage());
	}

	@Test
	void 시도횟수가_양수가_아니면_예외를_발생시킨다() {
		String input = "0";

		assertThatThrownBy(() -> new TryNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(NUMBER_POSITIVE_ERROR.getMessage());
	}
}
