package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private static final MovingStrategy ALWAYS_TRUE_MOVER = () -> true;
    private static final MovingStrategy ALWAYS_FALSE_MOVER = () -> false;

    @Test
    @DisplayName("이름을 가진 자동차를 만들 수 있다.")
    void create_car_with_name_success() {
        assertThat(new Car("jae", ALWAYS_TRUE_MOVER)).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이상일 수 없다")
    void create_car_with_name_fail_over_max_length() {
        assertThatThrownBy(() -> new Car("jaehun123", ALWAYS_TRUE_MOVER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름은 빈 글자일 수 없다")
    void create_car_with_name_fail_blank() {
        assertThatThrownBy(() -> new Car("", ALWAYS_TRUE_MOVER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차는 이동 전략이 성공하면 따라 움직일 수 있다")
    void car_moving_forward() {
        Car car = new Car("kkk", ALWAYS_TRUE_MOVER);
        car.move();
        assertThat(car.getCurrentStatus().position()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 이동 전략이 실패하면 따라 움직일 수 없다")
    void car_moving_can_not_move() {
        Car car = new Car("kkk", ALWAYS_FALSE_MOVER);
        car.move();
        assertThat(car.getCurrentStatus().position()).isZero();
    }
}
