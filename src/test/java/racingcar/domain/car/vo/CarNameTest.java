package racingcar.domain.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 경우 IllegalArgumentException을 반환한다")
    void car_construct_with_5length_over_name() {
        // given
        String name = "name-with-longer-than-5-length";

        // when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }
}
