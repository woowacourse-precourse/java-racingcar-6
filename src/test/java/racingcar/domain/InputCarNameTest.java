package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import org.junit.jupiter.api.Test;

public class InputCarNameTest {

	@Test
	void 자동차이름을_입력받아_InputCarName을_생성한다() {
		String input = "pobi,woni,jun";
		InputCarName inputCarName = new InputCarName(input);

		assertThat(inputCarName.getCarNameList()).hasSize(3)
			.containsExactlyInAnyOrder("pobi","woni","jun");
	}

	@Test
	void 자동차이름이_주어진조건보다_길때_예외를_발생시킨다() {
		String input = "pobi,woniii,jun";

		assertThatThrownBy(() -> new InputCarName(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(INVALID_CARNAME_LENGTH.getMessage());
	}

}
