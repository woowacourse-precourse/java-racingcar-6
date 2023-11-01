package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;

class RacingCarGameTest {
	@Test
	public void testStartGameWithNameZeroLength() {
		RacingCarGame game = new RacingCarGame();

		String inputForName = "\n";
		System.setIn(new ByteArrayInputStream(inputForName.getBytes()));

		assertThatThrownBy(game::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름을 입력하여 주십시오.");
	}

	@Test
	public void testStartGameWithNameOverFiveLength() {
		RacingCarGame game = new RacingCarGame();

		String inputForName = "pobiwoni,jun";
		System.setIn(new ByteArrayInputStream(inputForName.getBytes()));

		assertThatThrownBy(game::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
	}

	@Test
	public void testStartGameWithNameContinuousDelimiter() {
		RacingCarGame game = new RacingCarGame();

		String inputForName = "pobi,,woni,jun";
		System.setIn(new ByteArrayInputStream(inputForName.getBytes()));

		assertThatThrownBy(game::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
	}

	@Test
	public void testStartGameWithDuplicatedName() {
		RacingCarGame game = new RacingCarGame();

		String inputForName = "pobi,woni,jun,pobi";
		System.setIn(new ByteArrayInputStream(inputForName.getBytes()));

		assertThatThrownBy(game::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 중복되었습니다.");
	}
}
