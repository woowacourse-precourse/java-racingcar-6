package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -1})
    @DisplayName("0보다 작은 수는 예외 발생")
    void createCarPositionExceptionTest(final int position) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> CarPosition.from(position));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10})
    @DisplayName("0보다 크거나 같은 수는 정상 생성")
    void createCarPositionTest(final int position) {
        // expected
        assertDoesNotThrow(() -> CarPosition.from(position));
    }
}