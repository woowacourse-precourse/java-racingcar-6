package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

class RacingGameTest {

    private static final int MOVING_FORWARD = 4;

    @Test
    void 숫자_n이상_나오면_자동차_전진() {
        // given
        Car car = Car.createCar("pobi");

        // when
        car.moveOrStop(MOVING_FORWARD);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 숫자_n미만_나오면_자동차_이동X() {
        // given
        Car car = Car.createCar("pobi");

        // when
        car.moveOrStop(MOVING_FORWARD - 1);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 가장_많이_전진한_자동차가_게임우승() {
        // given
        RacingGame racingGame = new RacingGame();
        Car car1 = Car.createCar("pobi");
        Car car2 = Car.createCar("woni");
        Car car3 = Car.createCar("harry");
        List<Car> cars = List.of(car1, car2, car3);

        for (int i = 0; i < 4; i++) {
            car1.moveOrStop(MOVING_FORWARD);
        }
        racingGame.setCars(cars);

        // when
        List<Car> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @Test
    void 우승자가_여러_명이라면_모두_우승자() {
        // given
        RacingGame racingGame = new RacingGame();
        Car car1 = Car.createCar("pobi");
        Car car2 = Car.createCar("woni");
        Car car3 = Car.createCar("harry");
        List<Car> cars = List.of(car1, car2, car3);

        for (int i = 0; i < 4; i++) {
            car1.moveOrStop(MOVING_FORWARD);
            car2.moveOrStop(MOVING_FORWARD);
        }
        racingGame.setCars(cars);

        // when
        List<Car> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(2);
    }

    @Test
    void 입력_받은_자동차_이름_중복_존재_시_예외_발생() {
        // given
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        RacingGame racingGame = new RacingGame();
        RacingGameController racingGameController = new RacingGameController(outputManager, inputManager, racingGame);

        List<String> list = List.of("pobi", "pobi", "harry");

        // when & then
        assertThatThrownBy(() -> racingGameController.checkCarNameIsValid(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_정해진_글자수_초과시_예외_발생() {
        // given
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        RacingGame racingGame = new RacingGame();
        RacingGameController racingGameController = new RacingGameController(outputManager, inputManager, racingGame);

        List<String> list = List.of("pobia", "pobib", "harryc");

        // when & then
        assertThatThrownBy(() -> racingGameController.checkCarNameIsValid(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_최대_개수_초과시_예외_발생() {
        // given
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        RacingGame racingGame = new RacingGame();
        RacingGameController racingGameController = new RacingGameController(outputManager, inputManager, racingGame);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < RacingGame.CAR_MAX_NUM + 1; i++) {
            list.add("pobi");
        }

        // when & then
        assertThatThrownBy(() -> racingGameController.checkCarNameIsValid(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
