package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

class GameServiceTest {
    @Test
    void 라운드_횟수가_초과되면_현재_라운드수가_증가하지_않는다() {
        List<String> name = List.of("a", "b", "c");
        RacingGame racingGame = new RacingGame(2, name);

        GameService.playSingleRound(racingGame);
        assertThat(racingGame.getCurrentRound()).isEqualTo(1);

        GameService.playSingleRound(racingGame);
        assertThat(racingGame.getCurrentRound()).isEqualTo(2);

        GameService.playSingleRound(racingGame);
        assertThat(racingGame.getCurrentRound()).isEqualTo(2);
    }

    @Test
    void 가장_멀리_간_자동차가_우승자이다() {
        Car car1 = new Car("a");
        car1.go();
        car1.go();

        Car car2 = new Car("b");
        car2.go();

        Car car3 = new Car("c");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = GameService.getWinners(cars);
        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @Test
    void 가장_멀리_간_자동차가_여려_대인_경우_모두가_우승자이다() {
        Car car1 = new Car("a");
        car1.go();
        car1.go();

        Car car2 = new Car("b");
        car2.go();
        car2.go();

        Car car3 = new Car("c");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = GameService.getWinners(cars);
        assertThat(winners.get(0)).isEqualTo(car1);
        assertThat(winners.get(1)).isEqualTo(car2);
        assertThat(winners.size()).isEqualTo(2);
    }
}