package racingcar.domain.racing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

class RacingTest {
    private static final int RACING_GAME_EXIT = -1;

    @DisplayName("주어진 횟수 n번 동안 레이싱이 진행된다.")
    @Test
    void process() {
        // Arrange
        RacingCars cars = new RacingCars(List.of(
                new RacingCar("pobi"),
                new RacingCar("woni")
        ));
        Racing racing = new Racing(cars, 5);

        // Act
        racing.process();

        // Assert
        Assertions.assertEquals(RACING_GAME_EXIT, racing.getRound());
    }
}