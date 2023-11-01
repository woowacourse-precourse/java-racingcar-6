package racingcar.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGame 클래스를 테스트한다.")
class RacingGameTest {

	@Test
	@DisplayName("게임 결과의 우승자는 주어진 이름에 포함되어야 한다.")
	void winner() {
		// given
		var names = List.of("plyr1", "plyr2", "plyr3");
		var racingGame = new RacingGame(names);
		var turn = 5;
		racingGame.progressGame(turn);

		// when
		var results = racingGame.getWinners();

		// then
		results
			.forEach(
				result -> assertThat(names).contains(result.getName())
			);
	}

	@Test
	@DisplayName("5이하의 이름은 존재할 경우 예외를 던진다.")
	void wrongName() {
		// given
		var wrongNames = List.of("longestName");

		// when

		// then
		assertThatThrownBy(
			() -> new RacingGame(wrongNames))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("올바르지 않은 turn 값이 주어지면 예외를 던진다.")
	void wrongTurn() {
		// given
		var names = List.of("plyr1", "plyr2", "plyr3");
		var turn = -1;

		// when
		var racingGame = new RacingGame(names);

		// then
		assertThatThrownBy(
			() -> racingGame.progressGame(turn))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
