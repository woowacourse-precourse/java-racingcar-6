package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void new_이름이_5자_초과인_경우_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Car("123456"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void new_전진_횟수가_0회_미만인_경우_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Car("-1", -1))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("전진 횟수는 0회 이상만 가능합니다.");
    }

    @Test
    void moveForward() {
        Car car = new Car("1", 0);

        car.moveForward();

        assertThat(car.getForwardCount()).isEqualTo(1);
    }
}
