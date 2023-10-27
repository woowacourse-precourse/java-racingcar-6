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
    void 여러번_전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,esss", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP , STOP , MOVING_FORWARD, STOP , STOP , MOVING_FORWARD, STOP , STOP
        );
    }

    @Test
    void 우승자_여러명_전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,esss", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ---", "esss : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD , STOP , MOVING_FORWARD, MOVING_FORWARD , STOP
                , MOVING_FORWARD, MOVING_FORWARD , STOP
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
