package racingcar.unit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.validation.CarNameValidator;

public class CarTest {
    @Test
    public void testMove1() {
        Car car = new Car("testCar");
        car.move(4);  // 가정: 4 이상일 때만 움직인다
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void testMove2() {
        Car car = new Car("testCar");
        car.move(1);  // 가정: 4 이상일 때만 움직인다
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
