package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 차량움직임_Test() {
        Car testCar = new Car("pobi");
        testCar.moveForward(1);
        assertThat(testCar.getPosition()).isEqualTo(1);
    }
}
