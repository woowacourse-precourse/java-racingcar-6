package racingcar.global.utils.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

	private static final int MIN_NUMBER_OF_RANGE = 0;
	private static final int MAX_NUMBER_OF_RANGE = 9;

	@DisplayName("RandomNumberGenerator는 1초과 9미만의 숫자를 생성해야한다.")
	@Test
	void should_generateGreaterThan1AndLessThen9_when_randomNumberGenerator() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		int count = 1000;

		for (int index = 0; index < count; index++) {
			Assertions.assertThat(randomNumberGenerator.generate())
					.isGreaterThanOrEqualTo(MIN_NUMBER_OF_RANGE)
					.isLessThanOrEqualTo(MAX_NUMBER_OF_RANGE);
		}
	}
}
