package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
	// given
	final Game game = new Game();

	@DisplayName("사용자 이름에 공백이 포함이 되는지 확인")
	@Test
	void userNameIncludeSpace() {
		// given
		final String[] userInput = { "user ", "user2", "user3" };

		// when
		final String[] result = game.checkUsername(userInput);

		// then
		assertThat(result).doesNotContain(" ");
	}

	@DisplayName("사용자 이름 5자 이상일 경우 예외 발생")
	@Test
	void userNameLengthTest() {
		// given
		final String[] userInput = { "user1", "username5", "user3" };

		// then
		assertThatThrownBy(() -> {
			// when
			game.checkUsername(userInput);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
