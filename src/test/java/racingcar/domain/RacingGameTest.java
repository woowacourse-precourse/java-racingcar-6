package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

        racingGame.race(() -> 3);
        List<String> winners = racingGame.findWinners();

        assertThat(winners).containsExactly("pobi", "woni");
    }

    @Test
    @DisplayName("자동차 경주 게임이 끝나지 않은 상태에서 우승자를 찾으려 하면 예외가 발생한다.")
    void validateGameState() {
        assertThat(racingGame.isGameEnd()).isFalse();

        assertThatThrownBy(() -> racingGame.findWinners())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임이 종료되지 않은 상태에서 우승자를 찾을 수 없습니다.");
    }
}