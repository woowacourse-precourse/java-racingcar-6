package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

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
	@DisplayName("자동차 이름 입력 테스트 - 입력하지 않았을 경우 예외 처리")
	void carNameTest1() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("자동차 이름 입력 테스트 - 6글자 이상일 경우 예외 처리")
	void carNameTest2() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("jinwoo", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
}
