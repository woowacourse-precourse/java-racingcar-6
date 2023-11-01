package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("CarTest");
    }
    @Test
    void 자동차_전진_테스트() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void 자동차_멈춤_테스트() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
