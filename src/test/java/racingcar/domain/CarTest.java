package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_이름은_1자_이상_5자_이하만_가능하다() {
        assertThatThrownBy(() -> new Car("ABCDEF"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 이름은 1자 이상 5자 이하만 가능합니다.");

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 이름은 1자 이상 5자 이하만 가능합니다.");
    }
}