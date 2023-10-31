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
                    assertThat(output()).contains(
                            "pobi : -", "woni : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 게임을_진행한다1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi1,pobi2,pobi3", "5");
                    assertThat(output()).contains(
                            "pobi1 : -", "pobi2 : ", "pobi3 : -",
                            "pobi1 : --", "pobi2 : -", "pobi3 : --",
                            "pobi1 : ---", "pobi2 : --", "pobi3 : ---",
                            "pobi1 : ----", "pobi2 : ---", "pobi3 : ----",
                            "pobi1 : -----", "pobi2 : ----", "pobi3 : -----",
                            "최종 우승자 : pobi1, pobi3"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 게임을_진행한다2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi1,pobi2,pobi3,pobi4,pobi5", "3");
                    assertThat(output()).contains(
                            "pobi1 : -", "pobi2 : ", "pobi3 : -", "pobi4 : ", "pobi5 : -",
                            "pobi1 : -", "pobi2 : ", "pobi3 : --", "pobi4 : ", "pobi5 : -",
                            "pobi1 : --", "pobi2 : -", "pobi3 : --", "pobi4 : ", "pobi5 : --",
                            "최종 우승자 : pobi1, pobi3, pobi5"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
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
