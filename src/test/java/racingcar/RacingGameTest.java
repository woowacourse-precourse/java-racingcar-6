package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
	private RacingGame racingGame;

	@BeforeEach
	void Test() {
		racingGame = new RacingGame();
	}

	@Test
	@DisplayName("사용자에게 경주할 자동차 이름을 받아 쉼표로 구분하여 자동차를 만든다.")
	void inputCarNameTest() {
		String carNames = "aa,bb,cc";
		String[] result = racingGame.inputCarName(carNames);

		assertThat(result).contains("bb", "cc", "aa");
		assertThat(result).containsExactly("aa", "bb", "cc");
	}

	@Test
	@Order(2)
	@DisplayName("사용자에게 시도할 횟수를 받는다.")
	void inputTryCountExceptionTest() {

	}

	@Test
	@DisplayName("사용자에게 시도할 횟수를 받는다. 숫자를 입력하지 않으면 예외가 발생한다.")
	void inputTryCountExceptionTest2() {
	}

	@Test
	@DisplayName("사용자에게 실행 결과를 보여준다.")
	void showTheResultsTest() {

	}

	@Test
	@DisplayName("사용자에게 우승자를 안내한다.")
	void announceTheWinnersTest() {

	}
}
