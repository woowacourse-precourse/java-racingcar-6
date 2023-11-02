package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.random_generator.FakeRandomMove;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.game.CarStatus.RUN;

public class RacingGameTest {

    RacingGame racingGame;

    @DisplayName("자동차가 잘 만들어지는지 테스트")
    @Test
    void generateCarsTest() {
        racingGame = new RacingGame(new FakeRandomMove(0,1));
        String carName = "a,b,c,d";

        racingGame.generateCars(carName);

        List<Car> cars = racingGame.getCars().getCars();

        List<String> carNames = cars
                .stream()
                .map(Car::getName).toList();

        assertThat(carNames)
                .containsExactly("a","b","c","d");
    }

    @DisplayName("racingGame 시작시 status RUN인지 확인")
    @Test
    void startRacingGameTest() {
        racingGame = new RacingGame(new FakeRandomMove(0,1));
        racingGame.startRacingGame(4);

        assertThat(racingGame.isRunning())
                .isTrue();
    }
}
