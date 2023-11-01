package racingcar.domain.racing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

class RacingResultTest {

    @DisplayName("자동차 경주 게임 우승자가 한 명일 때 테스트")
    @Test
    void getFinalWinners() {
        // Arrange
        RacingCars cars = new RacingCars(
                List.of(
                        new RacingCar("pobi", 0),
                        new RacingCar("woni", 5),
                        new RacingCar("jun", 9)
                )
        );
        RacingResult racingResult = new RacingResult(cars);

        // Act
        List<String> winnerList = racingResult.getFinalWinnerList();

        // Assert
        Assertions.assertIterableEquals(winnerList, List.of("jun"));
    }

    @DisplayName("자동차 경주 게임 우승자가 여러 명일 때 테스트")
    @Test
    void getFinalWinnerList() {
        // Arrange
        RacingCars cars = new RacingCars(
                List.of(
                        new RacingCar("pobi", 9),
                        new RacingCar("woni", 5),
                        new RacingCar("jun", 9)
                )
        );
        RacingResult racingResult = new RacingResult(cars);

        // Act
        List<String> winnerList = racingResult.getFinalWinnerList();

        // Assert
        Assertions.assertIterableEquals(winnerList, List.of("pobi", "jun"));
    }
}