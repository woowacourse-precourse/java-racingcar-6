package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameExceptionTest extends NsTest {

    @Test
    void 자동차이름길이확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("overfiveword,may", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5자초과입니다,may", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 자동차이름중복확인() {
    }

    @Test
    void 자동차이름공백확인() {
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}