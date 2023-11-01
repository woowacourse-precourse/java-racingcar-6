package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class CarTest {
    @Test
    @DisplayName("::Car 객체 생성에 성공한다")
    void method1() {
        Car car = Car.createCar(new CarName("Car1"), 0);

        assertThat(car).isNotNull();
    }
}
