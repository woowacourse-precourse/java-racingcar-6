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
                assertThatThrownBy(() -> runException("pobi,javajigi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름을_아무것도_입력하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도회수에_숫자가_아닌_값을_입력하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "A"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도회수에_1_미만의_값을_입력하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 동시_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,java", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "java : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
