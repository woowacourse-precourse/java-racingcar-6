package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름_부여() {
        Car car = Car.of("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름이_5자_초과인_경우_예외_발생() {
        assertThatThrownBy(() -> Car.of("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름이_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> Car.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수입니다.");
    }

    @Test
    void 자동차_이름에_공백이_포함된_경우_예외_발생() {
        assertThatThrownBy(() -> Car.of("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백은 포함할 수 없습니다.");
    }
}