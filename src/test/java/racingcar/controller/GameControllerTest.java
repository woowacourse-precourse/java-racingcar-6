package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarCollection;
import racingcar.model.CarRepository;
import racingcar.model.CarService;
import racingcar.view.GameView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    private final CarService carService = new CarService(new CarRepository());
    private final GameView gameView = new GameView();
    private final GameController gameController = new GameController(carService, gameView);

    @Test
    void createCarObject_메서드로_입력받은_이름을_이용해_Car객체를_생성() {
        // Given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // When
        CarCollection carCollection = gameController.createCarCollection(carNames);

        // Then
        assertThat(carCollection.getCars())
                .extracting(Car::getName)
                .containsExactlyElementsOf(carNames);

        assertThat(carCollection.getCars())
                .extracting(Car::getCurrentLocation)
                .containsOnly(0);
    }
}
