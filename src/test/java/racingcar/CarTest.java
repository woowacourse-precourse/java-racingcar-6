package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
