package racingcar;

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
}


