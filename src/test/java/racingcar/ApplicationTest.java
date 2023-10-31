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
    void 정지_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 정지_전진_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,coni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "coni : -", "최종 우승자 : woni, coni");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,coni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "coni : -", "최종 우승자 : pobi, coni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 전진_전진_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,coni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "coni : -", "최종 우승자 : pobi, woni, coni");
                },
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
    void 이름_중복에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void N에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "av12s"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
