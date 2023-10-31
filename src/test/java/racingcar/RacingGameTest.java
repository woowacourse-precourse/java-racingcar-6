package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingGameTest extends NsTest {
	private RacingGame racingGame;
	private List<StringBuilder> steps = new ArrayList<>();
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@BeforeAll
	void Test() {
		racingGame = new RacingGame();
	}

	@Test
	@Order(1)
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
		String number = "3";
		int count = racingGame.inputTryCount(number);

		assertEquals(count, 3);
	}

	@Test
	@Order(3)
	@DisplayName("사용자에게 시도할 횟수를 받는다. 숫자를 입력하지 않으면 예외가 발생한다.")
	void inputTryCountExceptionTest2() {
		String number = "3a";

		assertThatThrownBy(() -> racingGame.inputTryCount(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자만 입력하실 수 있습니다.");
	}

	@Test
	@Order(4)
	@DisplayName("사용자에게 실행 결과를 보여준다.")
	void showTheResultsTest() {
		String[] cars = {"aa", "bb", "cc"};
		int count = 3;
		racingGame.makeCarStepList(cars.length);
		assertRandomNumberInRangeTest(
				() -> {
					racingGame.showTheResults(cars, count);
					assertThat(output()).contains(
							"aa : -", "bb : ", "cc : ",
							"bb : -",
							"aa : --", "bb : --", "cc : -"
					);
				},
				MOVING_FORWARD, STOP, STOP,
				STOP, MOVING_FORWARD, STOP,
				MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
		);
	}

	@Test
	@Order(5)
	@DisplayName("사용자에게 우승자를 안내한다.")
	void announceTheWinnersTest() {

	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
