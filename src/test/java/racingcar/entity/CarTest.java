package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Car car = Car.from("pobi");

        assertThat(car.describeSelf()).isEqualTo(new CarDescription("pobi", 0));
    }

    @DisplayName("알 수 없는 자동차 이동 정책(null)으로 자동차를 이동할 수 없다.")
    @Test
    void moveWithNull() {
        Car car = Car.from("pobi");

        assertThatThrownBy(() -> car.move(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 이동 정책입니다.");
    }

    @DisplayName("자동차가 이동할 수 있다면, 위치는 한 단계 증가한다.")
    @Test
    void move() {
        Car car = Car.from("pobi");

        car.move(() -> true);

        assertThat(car.describeSelf().position()).isEqualTo(1);
    }

    @DisplayName("자동차가 이동하지 못한다면, 위치는 증가할 수 없다.")
    @Test
    void canNotMove() {
        Car car = Car.from("pobi");

        car.move(() -> false);

        assertThat(car.describeSelf().position()).isEqualTo(0);
    }
}
