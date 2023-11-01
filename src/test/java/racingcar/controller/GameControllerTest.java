package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.CarService;
import racingcar.view.GameView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameControllerTest {

    private CarService carService = new CarService(new CarRepository());;
    private GameView gameView = new GameView();
    private GameController gameController = new GameController(carService, gameView);

    @Test
    void createCarObject_메서드로_입력받은_이름을_이용해_Car객체를_생성() {
        // Given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // When
        List<Car> cars = gameController.createCarObject(carNames);

        // Then
        assertThat(cars).extracting(Car::getName).containsExactlyElementsOf(carNames);
        assertThat(cars).extracting(Car::getCurrentLocation).containsOnly(0);
    }
}
