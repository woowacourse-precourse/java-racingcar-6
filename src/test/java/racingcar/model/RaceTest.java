package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.validator.AttemptNumberValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RaceTest {
    @Test
    void validateNumber_should_throw_exception_when_attempts_is_not_a_number() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 가능합니다.");
    }

    @Test
    void validateNumber_should_throw_exception_when_attempts_is_empty() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 공백일 수 없습니다.");
    }
}