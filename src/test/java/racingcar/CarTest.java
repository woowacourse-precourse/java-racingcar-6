package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    public void testMove_randomNumber_Below_Threshold() {
        // Given
        Car car = new Car("TestCar");

        // When
        car.move(1);

        // Then
        Assertions.assertEquals(0, car.getPosition().getPosition());
    }

    @Test
    public void testMove_randomNumber_Above_Threshold() {
        // Given
        Car car = new Car("TestCar");

        // When
        car.move(7);

        // Then
        Assertions.assertEquals(1, car.getPosition().getPosition());
    }

}
