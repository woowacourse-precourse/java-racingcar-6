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
    void 입력값을_자동차_이름_리스트로_변환() {
        // Given
        String input = "car1,car2,car3";

        // When
        List<String> actualCarNames = gameController.getCarNames(input);

        // Then
        List<String> expectedCarNames = Arrays.asList("car1", "car2", "car3");
        assertThat(actualCarNames).isEqualTo(expectedCarNames);
    }

    @Test
    void 이름을_이용해_Car_객체를_생성() {
        // Given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // When
        CarCollection actualCars = gameController.createCarCollection(carNames);

        // Then
        assertThat(actualCars.getCars())
                .extracting(Car::getName)
                .containsExactlyElementsOf(carNames);

        assertThat(actualCars.getCars())
                .extracting(Car::getCurrentLocation)
                .containsOnly(0);
    }

    @Test
    void 입력값을_정수로_변환() {
        // Given
        String input = "1";

        // When
        int actualTrialNumber = gameController.getTrialNumber(input);

        // Then
        assertThat(actualTrialNumber).isEqualTo(1);
    }

}
