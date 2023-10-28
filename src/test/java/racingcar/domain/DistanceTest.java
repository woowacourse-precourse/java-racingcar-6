package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @DisplayName("Distance 객체가 0보다 작은 경우 예외를 발생시킨다.")
    @Test
    void createDistanceExceptionTest() {
        // given
        int value = -1;

        // when & then
        Assertions.assertThatThrownBy(() -> new Distance(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("거리는 0보다 작을 수 없습니다.");
    }

    @DisplayName("전진하면 거리가 1 증가한다.")
    @Test
    void increaseDistanceSuccessTest() {
        // given
        Distance distance = new Distance(2);
        Distance target = new Distance(1);

        // when
        Distance increasedDistance = distance.increase(target);

        // then
        Assertions.assertThat(increasedDistance).isEqualTo(new Distance(3));
    }
}
