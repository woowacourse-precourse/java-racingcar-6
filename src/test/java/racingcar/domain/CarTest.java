package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void checkCarStatus_MoveTwice_Equals() {
        Car car = new Car("pobi");
        car.moveForward();
        car.moveForward();

        String result = car.status();

        assertThat(result).isEqualTo("pobi : --");
    }
}