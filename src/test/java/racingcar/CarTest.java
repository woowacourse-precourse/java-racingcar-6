package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void move_메서드에_조건에_부합하는_값_입력시_이동() {
        Car car = new Car("aaa");
        car.move(5);
        int result = car.getDistance();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void move_메서드에_조건에_부합하지_않는_값_입력시_멈춤() {
        Car car = new Car("aaa");
        car.move(3);
        int result = car.getDistance();

        assertThat(result).isEqualTo(0);
    }
}