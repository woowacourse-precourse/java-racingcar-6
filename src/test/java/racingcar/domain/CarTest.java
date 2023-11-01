package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void 이름에_대한_예외_처리() {
        assertThatThrownBy(() -> new Car("over5test"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}