package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 동일한_이름의_자동차_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_미입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_사이의_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름에_특수문자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi@,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수가_정수가_아닌_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수가_0_또는_음수인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수_미입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
