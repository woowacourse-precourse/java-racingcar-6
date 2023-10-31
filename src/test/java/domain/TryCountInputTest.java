package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountInputTest {
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -2, -3})
	public void 시도_횟수가_0이하이면_예외발생(int tryCount) {
		//given
		TryCountInput tryCountInput = new TryCountInput("1");

		// when & then
		Assertions.assertThatThrownBy(() -> tryCountInput.validatePositive(tryCount))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "12345678901", "a1"})
	public void 시도_횟수가_정수형이_아니라면_예외발생(String input) {
		//given
		TryCountInput tryCountInput = new TryCountInput("1");

		// when & then
		Assertions.assertThatThrownBy(() -> tryCountInput.validateAndParseInteger(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
