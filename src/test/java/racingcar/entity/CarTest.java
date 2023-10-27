package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Car car = Car.from("pobi");
        Car otherCar = Car.from("pobi");

        assertThat(car).isEqualTo(otherCar);
    }

    @DisplayName("자동차가 이동할 수 있다면, 위치는 한 단계 증가한다.")
    @Test
    void move() {
        Car car = Car.from("pobi");

        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 이동하지 못한다면, 위치는 증가할 수 없다.")
    @Test
    void canNotMove() {
        Car car = Car.from("pobi");

        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
