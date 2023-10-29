package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

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
	void 자동차이름이_5글자보다크면_예외를_발생시킨다() {
		String input = "pobi,woniii,jun";

		assertThatThrownBy(() -> new InputCarName(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5글자 이하만 가능합니다.");
	}

}
