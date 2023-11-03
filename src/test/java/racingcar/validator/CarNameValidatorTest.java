package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_DUPLICATED;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;


class CarNameValidatorTest {

    @Test
    void 긴_자동차_이름_검증() {
        String longNames = "fobiiiii,geonwoo,park,carr";
        assertThatThrownBy(() -> CarNameValidator.validate(longNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_LONGER);
    }

    @Test
    void 비어있는_자동차_이름_검증() {
        String emptyNames = "fobi,me,,,,,you";
        assertThatThrownBy(() -> CarNameValidator.validate(emptyNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_EMPTY);
    }

    @Test
    void 중복된_자동차_이름_검증() {
        String duplicatedNames = " fobi  ,   fobi    , park";
        assertThatThrownBy(() -> CarNameValidator.validate(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_DUPLICATED);
    }

    @Test
    void 올바른_자동차_이름_확인() {
        String properNames = "fobi,me, you  ";
        CarNameValidator.validate(properNames);
    }
}