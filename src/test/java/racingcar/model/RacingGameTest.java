package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.mock.TestNumberGenerator;
import racingcar.model.car.CarDTO;

class RacingGameTest {
    @Test
    void 이동_테스트() {
        // Arrange
        List<String> names = Arrays.asList("Car1", "Car2");
        RacingGame racingGame = new RacingGame(names, new JudgeWinnerImpl(), new TestNumberGenerator(5));

        // Act
        racingGame.move();
        List<CarDTO> carDTOList = racingGame.status();

        // Assert
        carDTOList.forEach(car -> {
            assertThat(car.step()).isEqualTo(1);
        });
    }

    @Test
    void 상태_테스트() {
        // Arrange
        List<String> names = Arrays.asList("Car1", "Car2");
        RacingGame racingGame = new RacingGame(names, new JudgeWinnerImpl(), new TestNumberGenerator(5));

        // Act
        List<CarDTO> carDTOList = racingGame.status();

        // Assert
        carDTOList.forEach(car -> {
            assertThat(car.step()).isEqualTo(0);
        });
    }

    @Test
    void 우승자_판별_테스트() {
        // Arrange
        List<String> names = Arrays.asList("Car1", "Car2");
        RacingGame racingGame = new RacingGame(names, new JudgeWinnerImpl(), new TestNumberGenerator(5));

        // Act
        List<String> winners = racingGame.judgeWinner();

        // Assert
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("Car1");
        assertThat(winners.get(1)).isEqualTo("Car2");
    }

}