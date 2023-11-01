package racingcar.domain.racing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

class RacingTest {
    private static final int RACING_GAME_EXIT = -1;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("주어진 횟수 n번 동안 레이싱이 진행된다.")
    void process(int value) {
        // Arrange
        List<RacingCar> carList = List.of(new RacingCar("pobi"), new RacingCar("woni"));
        RacingCars cars = new RacingCars(carList);
        Racing racing = new Racing(cars, value);

        // Act
        racing.process();

        // Assert
        Assertions.assertEquals(RACING_GAME_EXIT, racing.getRound());
    }
}