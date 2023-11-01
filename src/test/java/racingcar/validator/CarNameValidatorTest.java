package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameValidatorTest {
    @Test
    void validateCarNames_should_throw_exception_when_name_length_exceeds_maximum() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(List.of("pobi", "woni", "seobin")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR);
    }

    @Test
    void validateCarNames_should_throw_exception_when_duplicate_names_exist() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(List.of("pobi", "woni", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
    }

    @Test
    void validateCarNames_should_throw_exception_when_name_is_empty() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(List.of("pobi", " ", "woni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_EMPTY_ERROR);
    }

    @Test
    void validateCarNames_should_throw_exception_when_name_is_not_alphabet() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(List.of("pob1", "123")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_FORMAT_ERROR);
    }
}