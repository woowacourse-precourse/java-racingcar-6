package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"InvalidCarName", "abcdef"})
    void 자동차_이름_길이_검증(String carName) {
        // given & when & then
        assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하이어야 합니다.");
    }

    @Test
    void 자동차_이름_빈값_검증() {
        // given & when & then
        assertThatThrownBy(() -> Car.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 비어있을 수 없습니다.");
    }
}