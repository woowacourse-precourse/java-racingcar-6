package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_DUPLICATED;
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

        String duplicatedNames = " fobi  ,   fobi    , park";
        assertThatThrownBy(() -> CarNameValidator.validate(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_DUPLICATED);

        String properNames = "fobi,me, you  ";
        CarNameValidator.validate(properNames);
    }
}