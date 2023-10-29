package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RaceTest {
    @Test
    void 자동차_생성_검증() {
        var car = Car.createCar("pobi");
        assertThat(car.printPosition()).isEqualTo("pobi : ----");
    }
}
