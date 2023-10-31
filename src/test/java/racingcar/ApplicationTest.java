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
    void enterCarName_구분자가_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void enterMoveCount_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "a.; ,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void enterMoveCount_여러_자리의_숫자인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "12345"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void getWinnerNames_우승자의_이름을_반환하는_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun,qui", "1");
                assertThat(output()).contains("최종 우승자 : pobi, jun, qui");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
