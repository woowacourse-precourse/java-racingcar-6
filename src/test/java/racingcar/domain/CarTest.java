package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 차가_이동함() {
        Car car = new Car("tree");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차가_이동하지_않음2() {
        Car car = new Car("tree");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
