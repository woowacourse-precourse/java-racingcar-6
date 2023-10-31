package racingcar.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacingGameTest extends NsTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 게임_플레이() {
		assertRandomNumberInRangeTest(() -> {
					//given
					RacingGame racingGame = RacingGame.newRacingGame();
					//when
					run("name1,name2,name3", "2");
					racingGame.play();
					//then
					assertThat(output())
							.contains(
									"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
									"시도할 회수는 몇회인가요?",
									"name1 : -", "name2 : -", "name2 :",
									"name1 : --", "name2 : -", "name2 : -",
									"최종 우승자 : name1");
				},
				MOVING_FORWARD, MOVING_FORWARD, STOP,
				MOVING_FORWARD, STOP, MOVING_FORWARD
		);
	}

	@Override
	protected void runMain() {

	}
}