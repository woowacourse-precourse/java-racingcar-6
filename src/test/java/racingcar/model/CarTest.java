package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void moveForward() throws Exception {
        // given
        final Car car = new Car("test");

        // when
        car.moveForward(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void notMoveForward() throws Exception {
        // given
        final Car car = new Car("test");

        // when
        car.moveForward(3);

        // then
        assertThat(car.getPosition()).isZero();
    }
}
