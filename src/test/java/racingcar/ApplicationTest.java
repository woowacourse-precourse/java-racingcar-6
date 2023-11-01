package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 전진_정지() {
		assertRandomNumberInRangeTest(
				() -> {
					run("pobi,woni", "1");
					assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
				},
				MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi,javaji", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

	@Test
	@DisplayName("시도 횟수 테스트 - 입력하지 않았을 경우 IllegalArgumentException")
	void turnCountTest1() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi", null))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("시도 횟수 테스트 - 정수가 아닌 입력값일 경우 IllegalArgumentException")
	void turnCountTest2() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi", "one"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
}
