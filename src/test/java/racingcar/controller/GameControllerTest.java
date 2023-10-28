package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameControllerTest extends NsTest {
	@Test
	void 최종우승자_여러명() {
		assertRandomNumberInRangeTest(
			() -> {
				run("a,b,c,d", "1");
				assertThat(output()).contains("a : -", "b : -", "c : -", "d : ", "최종 우승자 : a, b, c");
			},
			4, 5, 6, 1
		);
	}

	@Test
	void 게임_횟수_0() {
		assertRandomNumberInRangeTest(
			() -> {
				run("a,b", "0");
				assertThat(output()).contains("최종 우승자 : a, b");
			},
			1, 2
		);
	}

	@Test
	void 이름_중복_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("a,b,a", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 메인_정상() {
		assertRandomNumberInRangeTest(
			() -> {
				run("a,b,c c,d	d d", "1");
				assertThat(output()).contains("a : -", "b : ", "cc : -", "dd : ", "최종 우승자 : a, cc");
			},
			8, 3, 9, 0
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}