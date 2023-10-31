package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest extends NsTest {

    @Test
    void checkNameInputSizeExceptionTest() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("heejun,hj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkNameInputCharExceptionTest() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hj 23,hj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkRepeatCountInputNumberExceptionTest() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hjun,hj", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}