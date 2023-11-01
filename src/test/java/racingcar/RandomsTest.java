package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsTest {

	@Test
	@DisplayName("pickNumberInRange() 메서드의 end 값을 포함한다.")
	void test01() {
		var count = 0;
		final var min = 0;
		final var max = 9;
		while (count < 1000) {
			final int number = Randoms.pickNumberInRange(min, max);
			assertThat(number)
				.isGreaterThan(min - 1)
				.isLessThan(max + 1);
			count++;
		}
	}
}
