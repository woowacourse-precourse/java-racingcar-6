package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.error.ErrorMessage.INVALID_LOOP_COUNT;
import static racingcar.error.ErrorMessage.NEGATIVE_LOOP_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoopCountTest {

    @Test
    @DisplayName("숫자이고 양수인 값으로 시도 횟수 객체 생성 성공한다.")
    void instance_PositiveNumber_Success() {
        // Given
        String count = "24";

        // When
        LoopCount result = LoopCount.of(count);

        // Then
        assertThat(result.getValue()).isEqualTo(Integer.parseInt(count));
    }

    @Test
    @DisplayName("숫자이며 음수인 값으로 시도 횟수 객체 생성 실패한다.")
    void instance_NegativeNumber_Fail() {
        // Given
        String count = "-2";

        // When & Then
        assertThatThrownBy(() -> LoopCount.of(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_LOOP_COUNT.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 값으로 시도 횟수 객체 생성 실패한다.")
    void instance_NotNumber_Fail() {
        // Given
        String count = "가나다";

        // When & Then
        assertThatThrownBy(() -> LoopCount.of(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOOP_COUNT.getMessage());
    }

}