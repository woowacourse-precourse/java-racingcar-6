package racingcar;

import org.junit.jupiter.api.Test;
import util.Validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateTest {
    Validate validate = new Validate();
    @Test
    void 자동차_이름을_한줄로_입력받을_때_앞에_콤마가_있을_때_예외_발생(){
        assertThatThrownBy(() -> validate.inputLineOfCarNames(",abc,def"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류]");
    }
}
