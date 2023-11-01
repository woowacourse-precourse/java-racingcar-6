package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNamesValidatorTest {
    @Test
    void 중복되는_이름_있으면_예외처리하는_테스트() {
        assertThatThrownBy(() -> {
            CarNamesValidator.validate("a,a");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_쉼표로_구분되지_않으면_예외처리하는_테스트() {
        assertThatThrownBy(() -> {
            CarNamesValidator.validate("a.b.c");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_두개_이상_받지않으면_예외처리하는_테스트() {
        assertThatThrownBy(() -> {
            CarNamesValidator.validate("a");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
