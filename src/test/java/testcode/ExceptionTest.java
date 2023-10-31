package testcode;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ExceptionTest extends NsTest {
    @Test
    void 자동차_이름_6글자이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("mickey,jack", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_한개만입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("name", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bob,jack,jack", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
