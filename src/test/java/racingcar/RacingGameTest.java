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
    @DisplayName("게임에 참여한 자동차가 없을 때 예외 발생 테스트")
    void createGameWithNoCars() {
        List<Car> cars = Arrays.asList();
        assertThatThrownBy(() -> new RacingGame(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임에 참여한 자동차가 없습니다.");
    }
}