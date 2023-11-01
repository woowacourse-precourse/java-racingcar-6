package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest extends  NsTest{

    @Test
    @DisplayName("testing_input_for_round")
    void roundInput() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("ej,david,paul", "st"))
                .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    @DisplayName("testing_same_names")
    void dupNameCheck() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ej,ej", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("testing_one_player")
    void onePlayersCheck() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("david", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("exception_when_zero_player")
    void zeroPlayersCheck() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
