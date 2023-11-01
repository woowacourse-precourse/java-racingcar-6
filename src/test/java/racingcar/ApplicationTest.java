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
    void 전진_정지_7회() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,grovy,whats", "7");
                    assertThat(output()).contains("pobi : -", "woni : ", "grovy : -", "whats : -",
                                                "pobi : --", "woni : -", "grovy : --", "whats : -",
                                                "pobi : ---", "woni : -", "grovy : ---", "whats : -",
                                                "pobi : ----", "woni : -", "grovy : ----", "whats : -",
                                                "pobi : -----", "woni : --", "grovy : -----", "whats : -",
                                                "pobi : ------", "woni : ---", "grovy : ------", "whats : -",
                                                "pobi : ------", "woni : ---", "grovy : ------", "whats : -",
                            "최종 우승자 : pobi, grovy");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, STOP, STOP, STOP
        );
    }


    @Test
    void 이름에_대한_예외_처리_5자이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리_0자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",javaji,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java i,wani", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드에_대한_예외_처리_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "1s"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리_정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
