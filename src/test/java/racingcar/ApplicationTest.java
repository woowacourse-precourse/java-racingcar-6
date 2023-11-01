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
    public void 시도할_회수에_대한_예외_처리() throws Exception {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 자동차_전진() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "10");
                    assertThat(output()).contains("pobi : ------", "최종 우승자 : pobi");
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );

    }

    @Test
    public void 공동_우승자_발표() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
