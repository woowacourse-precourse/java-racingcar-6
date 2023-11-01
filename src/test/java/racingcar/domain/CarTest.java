package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void 이름에_대한_예외_처리_5자초과() {
        assertThatThrownBy(() -> new Car("over5test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_대한_예외_처리_입력값이_비어있을때() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}