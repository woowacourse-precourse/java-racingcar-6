package racingcar.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameValidationTest {

    @Test
    void 자동차_이름을_쉼표로_구분하지_않으면_예외처리하는_테스트() {
        assertThatThrownBy(() -> {
            CarNameValidation.validation("pobi+owen-me");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되는_이름이_있으면_예외처리하는_테스트() {
        assertThatThrownBy(() -> {
            CarNameValidation.validation("pobi,pobi");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }


}
