package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class LocationValidatorTest {

    private final BasicValidator<Integer> locationValidator = new LocationValidator();

    @Test
    void 입력값이_자연수() {
        assertThatThrownBy(() -> locationValidator.validate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자연수가 아닙니다.");

        assertDoesNotThrow(
                () -> locationValidator.validate(0)
        );
    }
}