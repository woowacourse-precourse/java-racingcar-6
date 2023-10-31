package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("moveCounts가 0일 때 경기 종료 예외 발생")
    @Test
    public void testRaceEndsWhenMoveCountsIsZero() {
        // Arrange
        Race race = new Race();
        race.registerCar(List.of("Car1", "Car2"));
        race.registerMoveCounts(0);

        // Act and Assert
        assertThrows(IllegalStateException.class, race::startCarRacing);
    }

    @DisplayName("Fuel이 4 이상인 경우 이동")
    @Test
    public void testMoveOrStop() {
        // Arrange
        Car car = new Car("TestCar");
        int initialLocation = car.getLocation();

        // Act
        car.tryMove(4);

        // Assert
        int expectedLocation = initialLocation + 1;
        assertEquals(expectedLocation, car.getLocation());
    }
}


