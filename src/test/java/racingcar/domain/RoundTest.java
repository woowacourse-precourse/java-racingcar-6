package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0보다 작거나 같다면 예외 발생")
    void createRoundExceptionTest(final int round) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Round.from(round));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("0보다 큰 다면 정상 동작")
    void createRoundTest(final int round) {
        // expected
        assertDoesNotThrow(() -> Round.from(round));
    }
}