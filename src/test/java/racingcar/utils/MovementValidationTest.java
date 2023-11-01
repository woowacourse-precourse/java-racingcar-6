package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MovementValidationTest {

    private MovementValidation movementValidation;

    @BeforeEach
    void setUp() {
        movementValidation = new MovementValidation();
    }

    @DisplayName("사용자가 이동 회수에 0을 입력했을 때, 예외를 발생하는지")
    @Test
    void validateMovementIsZeroTest() {
        // given
        Integer movement = 0;

        // when & then
        assertThatThrownBy(
                () -> movementValidation.validateMovement(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동회수는 0을 입력할 수 없습니다.");
    }

    @DisplayName("사용자가 이동 횟수에 음수를 입력했을 때, 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -5, -25})
    void validateMovementNegativeNumberTest(Integer movement) {
        // given & when & then
        assertThatThrownBy(
                () -> movementValidation.validateMovement(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }
}