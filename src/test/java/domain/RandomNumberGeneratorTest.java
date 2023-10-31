package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
	// @ParameterizedTest
	// @ValueSource
	@Test
	public void 랜덤_숫자는_0_9사이의_숫자() {
		//given
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		// when
		int randomNumber = randomNumberGenerator.generateNumber();
		//then
		assertTrue(randomNumber >= 0); // 0 이상
		assertTrue(randomNumber < 10); // 10 미만
	}
}
