package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;
    Judge judge;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        judge = new Judge();
    }

    @Test
    void Car_앞으로_전진() {
        car.move(judge);
        assertThat(car.getScore()).isEqualTo(1);
    }

    @Test
    void Car_최초_점수_0() {
        assertThat(car.getScore()).isEqualTo(0);
    }
}