package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

public class CarTest {
    @Test
    void 차_생성_테스트() {
        String testCarName = "찬";
        Car car = Car.createCar(testCarName);

        assertThat(car.getName()).isEqualTo(testCarName);
    }

    @Test
    void 공백이_포함된_차_이름_입력값_테스트() {
        String testCarName = "우 아";

        assertThatThrownBy(() -> Car.createCar(testCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
