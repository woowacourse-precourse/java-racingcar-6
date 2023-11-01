package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
		assertRandomNumberInRangeTest(() -> {
			run("pobi,woni", "1");
			assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
		}, MOVING_FORWARD, STOP);
	}

	@Test
	void 자동차이름숫자확인() {
		assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 자동차이름중복입력확인() {
		assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,pobi", "1"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 공백시작입력확인() {
		assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi, woni", "1"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 잘못된시행숫자확인() {
		assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "0"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
