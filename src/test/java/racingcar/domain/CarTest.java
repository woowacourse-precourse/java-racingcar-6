package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void moveForward_메서드로_랜덤_번호가_4_이상이면_전진() {
        Car car = new Car("상추");
        car.moveForward(3);
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveForward(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}