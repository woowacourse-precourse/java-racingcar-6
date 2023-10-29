package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputCarNameTest {

	@Test
	void 자동차이름을_입력받아_InputCarName을_생성한다() {
		String input = "pobi,woni,jun";
		InputCarName inputCarName = new InputCarName(input);

		assertThat(inputCarName.getCarNameList()).hasSize(3)
			.containsExactlyInAnyOrder("pobi","woni","jun");
	}

}
