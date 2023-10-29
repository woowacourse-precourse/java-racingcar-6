package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.utils.MovementValidation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MovementValidationTest {

    private MovementValidation movementValidation;

    @BeforeEach
    void setUp() {
        movementValidation = new MovementValidation();
    }

    @DisplayName("사용자가 이동 횟수에 아무것도 입력하지 않았을 때, 예외를 발생하는지")
    @ParameterizedTest
    @NullSource
    void validateMovementNullTest(Integer movement) {
        // given & when & then
        assertThatThrownBy(
                () -> movementValidation.validateMovement(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요");
    }
}