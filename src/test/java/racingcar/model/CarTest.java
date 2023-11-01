package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void advanceTest() {
        int randomNumber = 4;
        Car car = new Car("test");
        car.advance(randomNumber);
        assertThat(car.getAdvanceCount()).isEqualTo(1);
    }
}
