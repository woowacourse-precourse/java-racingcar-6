package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class InputFunctionTest extends NsTest {
    @Test
    public void testInvalidInputList() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,raccoon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("One of the strings exceeds the allowed length: raccoon"));
    }

    @Test
    public void testValidInputInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "t"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("For input string: \"t\""));
    }

    @Test
    public void testValidInputNegative() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("The number must be greater than 0."));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}