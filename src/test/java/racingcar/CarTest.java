package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void testToString() {
        Car car = new Car("pobi");
        car.moveForward();
        car.moveForward();

        String result = car.toString();

        assertThat(result).isEqualTo("pobi : --");
    }
}
