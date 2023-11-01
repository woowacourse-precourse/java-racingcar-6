package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TryCountTest {

	@Test
	void 시도_횟수_앞에_있는_0_제거_테스트() {
		assertThat(new TryCount("000123456789").getTryCount())
				.isEqualTo(123456789);
	}
}
