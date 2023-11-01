package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.view.Input.InputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @Test
    void cars_공백_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.isNull(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_숫자_외_값_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.isNumberOnly("."))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_음수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.isPositiveOnly("-2"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }
}
