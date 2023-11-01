package controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerTest {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    @Test
    void 자동차들은_입력된_이름과_포지션_0_으로_초기화된다() {
        List<String> carNames = List.of("abc", "def");
        GameController gameController = new GameController(inputView, outputView);
        List<Car> cars= gameController.InitializeCars(carNames);
        Car compareCar = new Car("comp",0);

        Assertions.assertThat(cars.get(0).toString()).isEqualTo("abc");
        Assertions.assertThat(cars.get(0).isSamePosition(compareCar)).isTrue();
        Assertions.assertThat(cars.get(1).toString()).isEqualTo("def");
        Assertions.assertThat(cars.get(1).isSamePosition(compareCar)).isTrue();
    }
}
