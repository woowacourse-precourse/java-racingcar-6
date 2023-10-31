package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountInputTest {
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -2, -3})
	public void 시도_횟수가_0이하이면_예외발생(int tryCount) {
		//given
		TryCountInput tryCountInput = new TryCountInput();

		// when & then
		Assertions.assertThatThrownBy(() -> tryCountInput.validatePositive(tryCount))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
