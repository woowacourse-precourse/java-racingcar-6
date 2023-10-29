package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;

public class GameTest {
	// given
	final Game game = new Game();

	@DisplayName("사용자 이름에 공백이 포함이 되는지 확인")
	@Test
	void userNameIncludeSpace() {
		// given
		final String userInput = "user1,user2,user3";

		// when
		final String[] result = game.checkUsername(userInput);

		// then
		assertThat(result).doesNotContain(" ");
	}

	@DisplayName("사용자 이름 5자 이상일 경우 예외 발생")
	@Test
	void userNameLengthTest() {
		// given
		final String userInput = "user1,username,user3";

		// then
		assertThatThrownBy(() -> {
			// when
			game.checkUsername(userInput);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("사용자의 입력값이 숫자가 아닌 경우 예외 발생")
	@Test
	void isUserInputInt() {
		// given
		final String userInput = "가";

		// then
		assertThatThrownBy(() -> {
			// when
			game.intValidator(userInput);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이동 횟수가 가장 많은 사람의 인덱스 확인")
	@Test
	void findWinnerIndex() {
		// given
		final int[] moveCount = { 1, 5, 2 };

		// when
		final ArrayList<Integer> result = game.findMaxIndex(moveCount);

		// then
		assertThat(result).containsExactly(1);
	}

	@DisplayName("이동 횟수가 가장 많은 사람이 두명일 경우 인덱스 확인")
	@Test
	void findWinnerIndices() {
		// given
		final int[] moveCount = { 1, 5, 5, 2 };

		// when
		final ArrayList<Integer> result = game.findMaxIndex(moveCount);

		// then
		assertThat(result).containsExactly(1, 2);
	}

}
