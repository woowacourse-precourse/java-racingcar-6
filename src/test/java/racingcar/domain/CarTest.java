package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("Car1");
    }

    @Test
    void 랜덤_숫자_4이상일때_전진() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자_4미만일때_정지() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
