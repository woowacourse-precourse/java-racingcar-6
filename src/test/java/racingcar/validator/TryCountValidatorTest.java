package racingcar.validator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountValidatorTest {

    @Test
    void 실행_횟수_입력이_음수인_경우_예외_발생() {
        String inputCountTry = "-1";
        TryCountValidator tryCountValidator = new TryCountValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> tryCountValidator.checkInput(inputCountTry))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Try count input is invalid")
        );
    }

    @Test
    void 실행_횟수_입력이_숫자가_아닌_경우_예외_발생() {
        String inputCountTry = "가나다";
        TryCountValidator tryCountValidator = new TryCountValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> tryCountValidator.checkInput(inputCountTry))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Try count input is invalid")
        );
    }

    @Test
    void 실행_횟수_입력이_int_범위를_벗어나는_경우_예외_발생() {
        String inputCountTry = String.valueOf((long)Integer.MAX_VALUE + 1);
        TryCountValidator tryCountValidator = new TryCountValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> tryCountValidator.checkInput(inputCountTry))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Try count input is invalid")
        );
    }
}