package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 자동차_이름범위를_벗어났을_경우_예외처리를_한다(String name) {
        Assertions.assertThatThrownBy(() -> CarValidator.validate(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
