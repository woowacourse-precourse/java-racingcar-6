package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Generator;
import racingcar.utils.GeneratorImp;

class RacingCarServiceTest {
    private RacingCarService racingCarService;
    private Generator generator;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarServiceImp();
        generator = new GeneratorImp();
    }

    @Test
    @DisplayName("시도 횟수를 모두 시도하여 게임이 종료될 수 있는지 테스트 합니다.")
    void 게임_종료_확인() {
        Game game = Game.of(new ArrayList<>(), 1);
        assertThat(racingCarService.isEnd(game)).isFalse();
    }

    @Test
    @DisplayName("무작위 값에 따라 자동차가 전진 또는 멈춤 했는지 테스트 합니다.")
    void 자동차_전진_또는_멈춤_확인() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.from("pobi"));
        cars.add(Car.from("woni"));

        Game game = Game.of(cars, 1);
        racingCarService.moveCars(game);

        assertThat(cars.get(0).getLocation()).isBetween(0, 1);
        assertThat(cars.get(1).getLocation()).isBetween(0, 1);
    }
}