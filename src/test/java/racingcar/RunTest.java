package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 우승한명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : -", "woni : ----", "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱㄴ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC,,AB", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",ABC", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC,ABC", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC", "01"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABC", "1.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
