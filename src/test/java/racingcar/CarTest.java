package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("pobi");
    }

    @Test
    void 차_전진_확인() {
        car.forward(5);
        assertThat(car.state).isEqualTo(1);
    }
}