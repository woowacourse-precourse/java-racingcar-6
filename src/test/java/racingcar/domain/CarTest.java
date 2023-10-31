package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car = new Car("test");

    @Test
    void 랜덤숫자_전진_판단() {
        List<Integer> inputs = Arrays.asList(4, 8, 9);
        for (Integer input : inputs) {
            int prevDistance = car.getDistance();
            car.updateDistance(input);
            assertThat(car.getDistance()).isEqualTo(prevDistance + 1);
        }
    }

    @Test
    void 랜덤숫자_멈춤_판단() {
        List<Integer> inputs = Arrays.asList(0, 1, 3);
        for (Integer input : inputs) {
            int prevDistance = car.getDistance();
            car.updateDistance(input);
            assertThat(car.getDistance()).isEqualTo(prevDistance);
        }
    }
}
