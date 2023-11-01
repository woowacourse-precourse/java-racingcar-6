package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest extends NsTest {
    @Test
    void 이름_공백입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,  ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자초과_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobiwoni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_처음쉼표_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중간쉼표_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_마지막쉼표_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_0_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_음수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_문자입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "asdf"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}