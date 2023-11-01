package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void validateCarNames_should_throw_exception_when_name_length_exceeds_maximum() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(List.of("pobi", "woni", "seobin")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자 이하만 가능합니다.");
    }
}