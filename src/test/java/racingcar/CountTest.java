package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CountTest extends ApplicationTest {

    @Test
    void TestExceptionNonNumeric() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                       .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionNegative() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                      .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionZero() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                  .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionEmpty() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                      .isInstanceOf(IllegalArgumentException.class)
        );
    }



}
