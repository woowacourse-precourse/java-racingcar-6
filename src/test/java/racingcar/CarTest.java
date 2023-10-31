package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Car.ONE_STEP;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final String CAR_NAME = "aaa";

    @Test
    void move_메서드로_자동차_이동() {
        Car aaa = new Car(CAR_NAME);
        aaa.move(true);
        List<String> result = aaa.getDistance();

        assertThat(result).contains(ONE_STEP);
    }
}