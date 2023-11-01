package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputExceptionTest extends NsTest {

    @Test
    void name_length_when_up_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaaaaa,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trial_num_when_negative() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaa,jaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trial_num_when_not_Integer() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaa,jaji", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
