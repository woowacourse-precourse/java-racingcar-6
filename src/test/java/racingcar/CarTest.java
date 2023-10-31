package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

class CarTest {

    @Test
    @DisplayName("최종 우승자를 판별하는 메서드의 동작을 확인한다")
    void getRacingGameWinner_winnerIsRome() {

        List<Car> carNames = List.of(
                new Car("rome", 3),
                new Car("seoul", 2),
                new Car("tokyo", 1)
        );

        List<String> gameWinner = Car.getRacingGameWinner(carNames);
        Assertions.assertThat(gameWinner).containsExactly("rome");
    }

    @Test
    @DisplayName("공동 우승자를 판별하는 메서드의 동작을 확인한다")
    void getRacingGameWinner_winnerIsCommon() {

        List<Car> carNames = List.of(
                new Car("rome", 3),
                new Car("seoul", 3),
                new Car("tokyo", 1)
        );

        List<String> gameWinner = Car.getRacingGameWinner(carNames);
        Assertions.assertThat(gameWinner).contains("rome");
        Assertions.assertThat(gameWinner).contains("seoul");
    }
}