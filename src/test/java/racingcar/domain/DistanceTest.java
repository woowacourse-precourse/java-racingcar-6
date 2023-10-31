package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceTest {

    @DisplayName("자동차 위치 값으로 0 미만이 들어올 경우 예외가 발생한다.")
    @Test
    void validateCarDistanceIsMinus() {
        // given
        int distance = -1;

        // when, then
        assertThatThrownBy(() -> new Distance(distance))
                .isInstanceOf(IllegalArgumentException.class);
    }
}