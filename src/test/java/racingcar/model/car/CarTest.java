package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차는_4이상일때_전진한다() {
        Car car1 = new Car("a", 0, (minBound, maxBound) -> 3);
        car1.move();
        assertThat(car1.getPosition()).isEqualTo(0);

        Car car2 = new Car("b", 0, (minBound, maxBound) -> 4);
        car2.move();
        assertThat(car2.getPosition()).isEqualTo(1);
    }
}