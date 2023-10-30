package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;

class RacingCarServiceTest {
    private RacingCarService racingCarService;
    private List<Car> cars;
    private Game game;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarServiceImp();
        cars = new ArrayList<>();
        cars.add(Car.from("pobi"));
        cars.add(Car.from("woni"));
        game = Game.of(cars, 1);
    }

    @Test
    @DisplayName("무작위 값에 따라 자동차가 전진 또는 멈춤 했는지 테스트 합니다.")
    void 자동차_전진_또는_멈춤_확인() {
        racingCarService.moveCars(game);

        for (Car car : cars) {
            assertThat(car.getLocation()).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("게임 종료 후 우승자 찾기를 테스트 합니다.")
    void 우승자_찾기() {
        cars.get(0).move();
        List<String> result = racingCarService.getWinner(game);

        assertThat(result).isNotNull();
        assertThat(result).containsExactly("pobi");
    }
}