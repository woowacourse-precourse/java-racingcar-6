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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_주행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a", "10");
                    assertThat(output()).contains("a : ", "a : -", "a : --",
                            "a : ---", "a : ----", "a : -----", "a : ------", "최종 우승자 : a");
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @Test
    void 반복횟수에_대한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("race,app", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 복수_1등_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d,e,f,g", "1");
                    assertThat(output()).contains("최종 우승자 : a, c, e, f");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
