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

    // My test
    @Test
    void 숫자가_음수일_때에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("son,kane", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_입력이_문자일_때에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("son,kane", "ss"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈칸에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void printWinner_메서드_테스트() {
        assertRandomNumberInRangeTest(() ->
        {
            run("son,kane","1");
            assertThat(output()).contains("kane");},
                3,9
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
