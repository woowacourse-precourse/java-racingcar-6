package racingcar.utility;

import static org.assertj.core.api.Assertions.*;
import static racingcar.utility.RandomNumberGenerator.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	void 랜덤_숫자_생성_테스트_100회() {
		for (int i = 0; i < 100; i++) {
			assertThat(getRandomNumber()).isBetween(0, 9);
		}
	}
}
