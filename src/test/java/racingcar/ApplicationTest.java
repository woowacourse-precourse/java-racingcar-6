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
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void applicationTest_success_winner_is_pobi() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "2");
                assertThat(output()).contains("pobi : -", "woni : ", "jun : ", "pobi : --",
                    "woni : ", "jun : ");
            },
            MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void applicationTest_fail_negative_round() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void applicationTest_fail_no_round() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void applicationTest_fail_overflow_round() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0x7fffffff+1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void applicationTest_fail_empty_name() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void applicationTest_fail_no_name() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
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
        Application.main(new String[]{});
    }
}
