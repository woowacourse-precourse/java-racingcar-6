package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

	@DisplayName("자동차의 수만큼 무작위 수를 생성한다.")
	@Test
	void testCarCountEqualsRandomNumberCount() {
		int carCount = 3;
		NumberGenerator numberGenerator = new NumberGenerator();
		List<Integer> numbers = numberGenerator.generateRandomNumbers(carCount);
		assertThat(numbers.size()).isEqualTo(carCount);
	}
}