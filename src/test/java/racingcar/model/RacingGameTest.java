package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.dto.CarDto;

class RacingGameTest {
    @Test
    void 게임_참여_자동차_추가() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final List<Car> cars = List.of(new Car("pobi", () -> 0), new Car("woni", () -> 0));

        // when
        racingGame.addCar(cars.get(0));
        racingGame.addCar(cars.get(1));

        // then
        assertThat(racingGame.getResult()).hasSize(2);
    }

    @Test
    void 게임_자동차_이동() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final Car car = new Car("pobi", () -> 5);
        racingGame.addCar(car);

        // when
        racingGame.moveCar();

        // then
        final CarDto result = racingGame.getResult().get(0);
        assertThat(result.position()).isEqualTo(1);
    }

    @Test
    void 게임_자동차_멈춤() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final Car car = new Car("pobi", () -> 3);
        racingGame.addCar(car);

        // when
        racingGame.moveCar();

        // then
        final CarDto result = racingGame.getResult().get(0);
        assertThat(result.position()).isZero();
    }

    @Test
    void 게임_결과() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final List<Car> cars = List.of(new Car("pobi", () -> 3), new Car("woni", () -> 7));
        for (final Car car : cars) {
            racingGame.addCar(car);
        }

        // when
        for (int count = 0; count < 5; count++) {
            racingGame.moveCar();
        }

        // then
        final List<CarDto> result = racingGame.getResult();
        assertThat(result.get(0).name()).isEqualTo("pobi");
        assertThat(result.get(0).position()).isZero();
        assertThat(result.get(1).name()).isEqualTo("woni");
        assertThat(result.get(1).position()).isEqualTo(5);
    }

    @Test
    void 게임_단독_우승() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final List<Car> cars = List.of(
                new Car("pobi", () -> 3),
                new Car("woni", () -> 7),
                new Car("jun", () -> 1));
        for (final Car car : cars) {
            racingGame.addCar(car);
        }

        // when
        for (int count = 0; count < 3; count++) {
            racingGame.moveCar();
        }

        // then
        final List<CarDto> result = racingGame.getWinners();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).name()).isEqualTo("woni");
    }

    @Test
    void 게임_공동_우승() throws Exception {
        // given
        final RacingGame racingGame = new RacingGame();
        final List<Car> cars = List.of(
                new Car("pobi", () -> 3),
                new Car("woni", () -> 7),
                new Car("jun", () -> 9));
        for (final Car car : cars) {
            racingGame.addCar(car);
        }

        // when
        for (int count = 0; count < 3; count++) {
            racingGame.moveCar();
        }

        // then
        final List<CarDto> result = racingGame.getWinners();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).name()).isEqualTo("woni");
        assertThat(result.get(1).name()).isEqualTo("jun");
    }
}
