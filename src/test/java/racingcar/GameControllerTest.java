package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.controller.GameController;

public class GameControllerTest {
	GameController gameController = new GameController();

	@DisplayName("숫자 이외의 문자가 입력되면 오류가 발생하는지 확인")
	@Test
	void attemptCountTest() {

		//given
		String input = "12L";

		final String MESSAGE = "숫자만 입력해주세요.";
		//when, then
		assertThatThrownBy(() -> gameController.validateAttemptCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(MESSAGE);
	}
}
