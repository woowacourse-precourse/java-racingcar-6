package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car의 movingCount를 증가시키는 메서드 동작을 확인한다.")
    void increaseMovingCount_successful() {
        /**
         * given : Car 객체를 생성한다.
         * when : increaseMovingCount 메서드를 호출한다.
         * then : Car의 count 예상값은 1이다.
         */
        Car car = new Car("rome", 0);
        car.increaseMovingCount();

        assertThat(car.getMovingCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("최종 우승자를 판별하는 메서드의 동작을 확인한다")
    void getRacingGameWinner_winnerIsRome() {
        /**
         * given : 3대의 Car 객체를 생성하여 List에 담는다.
         * when : getRacingGameWinner 메서드를 호출한다.
         * then : count가 가장 높은 이름인 "rome"이 gameWinner의 유일한 값이다.
         */

        List<Car> carNames = List.of(
                new Car("rome", 3),
                new Car("seoul", 2),
                new Car("tokyo", 1)
        );

        Winner winner = new Winner(carNames);
        List<String> gameWinner = winner.getWinners();
        assertThat(gameWinner).containsExactly("rome");
    }

    @Test
    @DisplayName("공동 우승자를 판별하는 메서드의 동작을 확인한다")
    void getRacingGameWinner_winnerIsCommon() {
        /**
         * given : 3대의 Car 객체를 생성하여 List에 담는다.
         * when : getRacingGameWinner 메서드를 호출한다.
         * then : count가 가장 높으면서 동률인 "rome"과 "seoul"이 gameWinner의 값이다.
         */

        List<Car> carNames = List.of(
                new Car("rome", 3),
                new Car("seoul", 3),
                new Car("tokyo", 1)
        );

        Winner winner = new Winner(carNames);
        List<String> gameWinner = winner.getWinners();
        assertThat(gameWinner).contains("rome", "seoul");
    }
}