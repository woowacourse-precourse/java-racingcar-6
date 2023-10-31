package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @Test
    void 이름이_5자_이상일_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate("longName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 이름이_공백으로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(" name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 공백으로 시작하면 안됩니다.");
    }

    @Test
    void 이름이_공백으로_끝난_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate("name "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 공백으로 끝나면 안됩니다.");
    }
}
