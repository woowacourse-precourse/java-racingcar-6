package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    public void IllegalArgumentException_When_moveCounts_Is_0() {
        Race race = new Race();
        race.registerCar(List.of("Car1", "Car2"));
        race.registerMoveCounts(0);

        Assertions.assertThrows(IllegalArgumentException.class, race::startCarRacing);
    }

    @Test
    public void Location_Does_Not_Change_When_Fuel_Under_4() {
        // Arrange
        Car car = new Car("TestCar");
        int initialLocation = car.getLocation();

        // Act
        car.tryMove(4);

        // Assert
        int expectedLocation = initialLocation + 1;
        Assertions.assertEquals(expectedLocation, car.getLocation());
    }

    @Test
    public void Location_Does_Change_When_Fuel_Over_5() {
        Car car = new Car("test");
        car.tryMove(7);
        Assertions.assertEquals(1, car.getLocation());
    }

}


