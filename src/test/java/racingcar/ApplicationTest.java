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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_음수_입력할_때_예외_처리() {
        assertThatThrownBy(() -> runException("pobi,jun", "-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수에_숫자_아닌_값_입력할_때_예외_처리() {
        assertThatThrownBy(() -> runException("pobi,jun", "abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수에_0을_입력할_때_예외_처리() {
        assertThatThrownBy(() -> runException("pobi,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_예외_처리() {
        assertThatThrownBy(() -> runException(",,", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_예외_처리_2() {
        assertThatThrownBy(() -> runException("a,b,", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_예외_처리_3() {
        assertThatThrownBy(() -> runException("a,k b,", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
