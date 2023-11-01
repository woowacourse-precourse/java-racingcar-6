package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberGeneratorTest {

	@Test
	void createRandomNumberWithPositiveMaxNumber() {
		int maxNumber = 9;
		int randomNumber = NumberGenerator.createRandomNumber(maxNumber);
		assertThat(randomNumber).isBetween(0, maxNumber);
	}

	@Test
	void createRandomNumberWithNegativeMaxNumber() {
		int maxNumber = -1;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> NumberGenerator.createRandomNumber(maxNumber));
		assertThat(exception.getMessage()).isEqualTo("인수는 0 이상의 값이어야 합니다.");
	}
}
