package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    @DisplayName("자동자 이름이 null인 경우")
    void shouldThrowExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> CarNameValidator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
