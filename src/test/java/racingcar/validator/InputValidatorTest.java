package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
	@DisplayName("자동차 이름 길이 테스트")
	@Test
	void 자동차_이름_길이_테스트() {
		List<String> players = new ArrayList<>();
		players.add("name");
		players.add("longer");
		assertThatThrownBy(() -> {
			InputValidator.validatePlayers(players);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도 횟수 정수 체크")
	@Test
	void 시도_횟수_정수_체크() {
		String input = "aa";
		assertThatThrownBy(() -> {
			InputValidator.validateTryNumber(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
