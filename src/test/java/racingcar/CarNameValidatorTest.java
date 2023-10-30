package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;


class CarNameValidatorTest {

    @Test
    void 자동차_이름_검증_테스트() {
        String longNames = "fobiiiii, geonwoo, park, carr";
        assertThatThrownBy(() -> CarNameValidator.validate(longNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_LONGER);
    }
}