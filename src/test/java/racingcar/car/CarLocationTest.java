package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarLocationTest {
    @DisplayName("음수인 위치값을 넣었을 때, 정확한 예외메시지를 출력하는지 확인합니다.")
    @Test
    void constructor_WithInvalidInput_ThrowsException() {
        assertThatThrownBy(() -> new CarLocation(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치값은 음수일 수 없습니다.");
    }
}