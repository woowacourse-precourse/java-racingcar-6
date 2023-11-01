package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.Arrays;
import java.util.List;

class RacingGameTest {

    @Test
    @DisplayName("자동차 이동 및 우승자 계산 테스트")
    void moveCarsAndCalculateWinners() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        List<Car> cars = Car.createCars(carNames);
        RacingGame racingGame = new RacingGame(cars);

        int maxDistance = 0;
        for (int i = 0; i < 10; i++) {
            racingGame.moveCars();
            for (Car car : cars) {
                maxDistance = Math.max(maxDistance, car.getDistance());
            }
        }

        List<Car> winners = racingGame.getWinners();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                assertThat(winners).contains(car);
            } else {
                assertThat(winners).doesNotContain(car);
            }
        }
    }

    @Test
    @DisplayName("자동차가 한 대인 경우 우승자가 자기 자신인지 확인")
    void singleCarGameWinner() {
        Car car = new Car("car1");
        RacingGame racingGame = new RacingGame(Arrays.asList(car));

        racingGame.moveCars();

        assertThat(racingGame.getWinners()).containsExactly(car);
    }

    @Test
    @DisplayName("자동차 이동 결과 유지 테스트")
    void keepCarDistanceAfterMultipleMoves() {
        Car car = new Car("car1");
        RacingGame racingGame = new RacingGame(Arrays.asList(car));

        int initialDistance = car.getDistance();
        racingGame.moveCars();
        racingGame.moveCars();

        assertThat(car.getDistance()).isEqualTo(initialDistance + 1);
    }

    @Test
    @DisplayName("게임에 참여한 자동차가 없을 때 예외 발생 테스트")
    void createGameWithNoCars() {
        List<Car> cars = Arrays.asList();
        assertThatThrownBy(() -> new RacingGame(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임에 참여한 자동차가 없습니다.");
    }
}