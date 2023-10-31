package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 전진_기능_확인() {
        Car car = new Car("pobi");

        assertThat(car.getStraightCount()).isEqualTo(0);

        car.goStraight();

        assertThat(car.getStraightCount()).isEqualTo(1);
    }
}
