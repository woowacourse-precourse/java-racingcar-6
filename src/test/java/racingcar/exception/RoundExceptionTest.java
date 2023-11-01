package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RoundExceptionTest extends NsTest {

    @Test
    void 정수로입력된라운드수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("april,may", "ㄱㄱ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}