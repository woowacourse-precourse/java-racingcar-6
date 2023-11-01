package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-11, -1, 0})
    void 양의_정수가_아닐때_예외처리를_한다(int value) {
        Assertions.assertThatThrownBy(() -> TryValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
