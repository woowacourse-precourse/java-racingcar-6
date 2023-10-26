package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private List<Car> cars;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        racingGame = new RacingGame(cars, 1);
    }

    @Test
    @DisplayName("자동차 경주를 진행할 수 있다.")
    void race() {
        racingGame.race(() -> 4);

        assertThat(cars).containsExactly(
                new Car("pobi", 1),
                new Car("woni", 1),
                new Car("jun", 1));
    }

    @Test
    @DisplayName("자동차 경주 게임에 대한 종료 여부를 알 수 있다.")
    void isGameEnd() {
        assertThat(racingGame.isGameEnd()).isFalse();

        racingGame.race(new RandomNumberGenerator());

        assertThat(racingGame.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("자동차 경주 게임의 우승자를 알 수 있다.")
    void findWinners() {
        List<Car> cars = List.of(
                new Car("pobi", 3),
                new Car("woni", 3),
                new Car("jun", 1));
        RacingGame racingGame = new RacingGame(cars, 1);

        List<Car> winners = racingGame.findWinners();

        assertThat(winners).containsExactly(new Car("pobi", 3), new Car("woni", 3));
    }
}