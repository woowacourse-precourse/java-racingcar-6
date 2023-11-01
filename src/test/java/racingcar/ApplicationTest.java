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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 우승자_여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 시도할_횟수는_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동자_이름은_없을수있음() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,", "1");
                    assertThat(output()).contains("pobi : -", " : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동자_이름은_하나도_없을수있음() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(",,", "1");
                    assertThat(output()).contains(" : -", " : ", " : -", "최종 우승자 : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

}
