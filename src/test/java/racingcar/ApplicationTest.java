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
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,flap", "2");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "flap : -",
                            "pobi : --",
                            "woni : --",
                            "flap : -",
                            "최종 우승자 : pobi, woni"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,STOP
        );
    }

    @Test
    void 공동_우승_3인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,flap", "2");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "flap : -",
                            "pobi : --",
                            "woni : --",
                            "flap : --",
                            "최종 우승자 : pobi, woni, flap"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD
        );
    }

    @Test
    void 시도횟수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "asdwasd"))
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
