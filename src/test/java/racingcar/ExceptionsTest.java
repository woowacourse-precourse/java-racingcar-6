package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ExceptionsTest extends NsTest {
    @Test
    void nameIsNull() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(null, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void onlyOneName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qqq", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameTooLong() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qqqq,wwwww,eeeeee", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameDupeExists() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qqq,www,qqq", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trialIsNull() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qqq,www,eee", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trialNotNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qqq,www,eee", "1q"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
