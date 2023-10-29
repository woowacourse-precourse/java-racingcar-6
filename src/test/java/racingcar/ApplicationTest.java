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
        // join test
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 최소_입력_개수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // duplicated name test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        //  space in the last test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ,jaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        //  space in the middle test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pob i,jaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_입력에_대한_예외_처리() {
        // input space test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javji", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // input special letter test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javji", ")"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // input number with space test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javji", " 1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // input number with space test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javji", " 1 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // input number with space test
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javji", "1 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}