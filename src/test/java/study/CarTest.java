package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    void 이름_확인() {
        assertThat(car.getName()).isEqualTo("TestCar");
    }

    @Test
    void 초기_위치_확인() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
