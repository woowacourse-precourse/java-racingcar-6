package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class MyTest {
    @Test
    void 문자열이_5보다_클때() {
        assertThatThrownBy(() -> {
            Car car = new Car("sdfsdfsd"); })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차가_잘_안움직이나() {
        Car car = new Car("Tony");
        car.go(0);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 차가_잘_움직이나() {
        Car car = new Car("Tony");
        car.go(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
