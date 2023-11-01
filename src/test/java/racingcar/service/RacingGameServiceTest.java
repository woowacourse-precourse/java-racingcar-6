package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {
    private final RacingGameService racingGameService = new RacingGameService();

    @Test
    void validateCount() {
        int count = 1;
        boolean result = racingGameService.validateCount(count);

        assertThat(result).isTrue();
    }

    @Test
    void validateCountFail() {
        int count = -1;
        boolean result = racingGameService.validateCount(count);

        assertThat(result).isFalse();
    }

    @Test
    void validateCarName() {
        String carName = "a,b,c";
        boolean result = racingGameService.validateCarName(carName);

        assertThat(result).isTrue();
    }

    @Test
    void validateCarNameFail() {
        String carName = "abcdefg,b,c";
        boolean result = racingGameService.validateCarName(carName);

        assertThat(result).isFalse();
    }

    @Test
    void moveCars() {
        Car car1 = new Car("a", 0);
        Car car2 = new Car("b", 0);
        Car car3 = new Car("c", 0);

        car1.move();
        car2.move();
        car2.move();

        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car2.getDistance()).isEqualTo(2);
        assertThat(car3.getDistance()).isEqualTo(0);
    }

    @Test
    void findWinners() {
        RacingGame racingGame = new RacingGame();
        String[] carNames = {"a", "b", "c"};
        racingGameService.setCarsInRacingGame(carNames, racingGame);
        List<Car> cars = racingGame.getCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        car1.move();
        car2.move();
        car2.move();
        car3.move();
        car3.move();
        List<Car> winners = racingGameService.findWinners(racingGame);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains(car2, car3);
    }

    @Test
    void parseCarName() {
        String input = "a,b,c";
        String[] carNames = racingGameService.parseCarName(input);
        assertThat(carNames).contains("a", "b", "c");
    }

    @Test
    void setCarsInRacingGame() {
        RacingGame racingGame = new RacingGame();
        String[] carNames = {"a", "b", "c"};
        racingGameService.setCarsInRacingGame(carNames, racingGame);

        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }
}