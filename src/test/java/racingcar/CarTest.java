package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void move_메서드_호출시_자동차_position_길이_증가() {
        Car car = new Car("hello");

        assertThat(car.getPositionLength()).isEqualTo(0);
        car.move();
        assertThat(car.getPositionLength()).isEqualTo(1);
    }

    @Test
    void getCarStatus_메서드_호츨시_이름과_위치_반환() {
        Car car = new Car("pkh");

        assertThat(car.getCarStatus()).isEqualTo("pkh : ");
        car.move();
        assertThat(car.getCarStatus()).isEqualTo("pkh : -");
        car.move();
        assertThat(car.getCarStatus()).isEqualTo("pkh : --");
    }
}