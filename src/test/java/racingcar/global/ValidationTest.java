package racingcar.global;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ValidationTest extends NsTest {

    @Test
    void validateName() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("moreThanFive"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateRound() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("user", "text"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}