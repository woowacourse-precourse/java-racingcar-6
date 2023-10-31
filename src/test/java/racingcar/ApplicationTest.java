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
    private static final int UNDER_FOUR = 3;
    private static final int OVER_FOUR = 5;

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
    void 무작위_값에_대한_전진_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
                },
                UNDER_FOUR, OVER_FOUR
        );
    }

    @Test
    void 단독_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : ",
                            "pobi : -", "woni : -","jun : ",
                            "pobi : --","woni : -","jun : ",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP

        );
    }

    @Test
    void 공동_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -","jun : --",
                            "pobi : ---","woni : --","jun : ---",
                            "pobi : ----","woni : ---","jun : ----",
                            "pobi : ----","woni : ----","jun : -----",
                            "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
