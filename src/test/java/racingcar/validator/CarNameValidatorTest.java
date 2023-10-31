package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;


class CarNameValidatorTest {

    @Test
    void 자동차_이름_검증_테스트() {
        String longNames = "fobiiiii,geonwoo,park,carr";
        assertThatThrownBy(() -> CarNameValidator.validate(longNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_LONGER);

        String emptyNames = "fobi,me,,,,,you";
        assertThatThrownBy(() -> CarNameValidator.validate(emptyNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_EMPTY);

        String properNames = "fobi,me, you  ";
        CarNameValidator.validate(properNames);
    }
}