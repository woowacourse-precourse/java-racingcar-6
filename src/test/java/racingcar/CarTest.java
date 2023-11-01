package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void testAddAdvance() {
        Car car = new Car("test");
        car.addAdvance();
        assertThat(car.getAdvance() == 1 || car.getAdvance() == 0);
    }
}
