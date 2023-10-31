package racingcar.validator;

import static racingcar.constant.Constants.EXCEPTION_BLACK_INPUT;
import static racingcar.constant.Constants.EXCEPTION_DOUBLE_USE_SEPARATOR;
import static racingcar.constant.Constants.EXCEPTION_SEPARATOR_END;
import static racingcar.constant.Constants.EXCEPTION_SEPARATOR_START;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameSplitValidatorTest {
    @Test
    void 여러빈칸입력() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_BLACK_INPUT);
    }

    @Test
    void 빈칸입력() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_BLACK_INPUT);

    }

    @Test
    void 아무것도_입력되지_않았을때() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_BLACK_INPUT);

    }

    @Test
    void 쉼표로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(",name,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_SEPARATOR_START);

    }

    @Test
    void 쉼표로_끝나는_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("name,name,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_SEPARATOR_END);
    }

    @Test
    void 쉼표를_연속으로_사용한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("name,,,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_DOUBLE_USE_SEPARATOR);
    }
}
