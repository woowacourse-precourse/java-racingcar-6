package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ExceptionMessage.CarException.INVALID_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.CarException.NAME_MUST_BE_EXISTS;

public class CarTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null이거나 비어있다면 Car를 생성할 수 없다")
    void throwExceptionByNameIsNullOrEmpty(final String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_MUST_BE_EXISTS.message);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 Car를 생성할 수 없다")
    void throwExceptionByInvalidNameLength() {
        // given
        final String name = "a".repeat(6);

        // when - then
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "hello", "hi123"})
    @DisplayName("Car를 생성한다")
    void construct(final String name) {
        assertDoesNotThrow(() -> Car.from(name));
    }
}
