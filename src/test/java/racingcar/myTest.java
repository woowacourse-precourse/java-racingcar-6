package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class myTest {

    @Test
    void 자동차_생성() {
        Car car = new Car("myCar");
        assertThat(car.getMovingDistance()).isEqualTo(0);
        assertThat(car.toString()).isEqualTo("myCar : ");
    }
}
