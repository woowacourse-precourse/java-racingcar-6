package racingcar.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class UserInputValidatorTest extends NsTest {

    @DisplayName("이름은 5자를 초과하지 않아야 한다.")
    @Test
    void nameDoesNotExceedLimit() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름은 공백이어서는 안된다.")
    @Test
    void nameShouldNotBeBlank() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,good", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수는 숫자이어야 한다.")
    @Test
    void tryCountShouldBeNumeric() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "ABC"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수는 공백이어서는 안 된다.")
    @Test
    void tryCountShouldBeProvided() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}