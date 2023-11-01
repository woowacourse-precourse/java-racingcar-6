package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class CarTest {
    @Test
    void tryMove_Should_Increase_Location_When_Fuel_Sufficient() {
        // Arrange
        Car car = new Car("Car1");
        int initialLocation = car.getLocation();
        int fuel = Constants.MINIMUM_MOVE_FUEL_LEVEL;

        // Act
        car.tryMove(fuel);

        // Assert
        assertEquals(initialLocation + 1, car.getLocation());
    }

    @Test
    void tryMove_ShouldNot_Increase_Location_When_Fuel_Insufficient() {
        Car car = new Car("Car2");
        int initialLocation = car.getLocation();
        int fuel = Constants.MINIMUM_MOVE_FUEL_LEVEL - 1;

        car.tryMove(fuel);

        assertEquals(initialLocation, car.getLocation());
    }
}