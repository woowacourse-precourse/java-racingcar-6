package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
	void 전진_정지_동시_우승자() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni,joon", "1");
				assertThat(output()).contains("pobi : -", "woni : -", "joon : ",
					"최종 우승자 : pobi, woni");
			},
			MOVING_FORWARD, MOVING_FORWARD, STOP
		);
	}

	@Test
	void 전진_정지_동시_우승자2() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni,jun", "5");
				assertThat(output()).contains("pobi : -----","woni : ----", "jun : -----", "최종 우승자 : pobi, jun");
			},
			MOVING_FORWARD, STOP, MOVING_FORWARD,
			MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
			MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
			MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
			MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,javaji", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_없을때_예외_처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(",pobi,woni", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_없을때_예외_처리_2() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,woni,", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_없을때_예외_처리_3() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,,woni", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름을_다른_문자로_나눴을때_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi/woni", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름을_다른_문자로_나눴을때_예외처리2() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi woni", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름을_다른_문자로_나눴을때_예외처리3() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("p w", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_공백으로_이루어져_있을때_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("    ,pobi,woni", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_겹쳤을때_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,pobi", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름_입력이_없을때_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("", "1"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 이동_횟수가_숫자형태가_아닐때_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,woni", "1a"))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
