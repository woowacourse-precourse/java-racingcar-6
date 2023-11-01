package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarGameController;
import racingcar.model.Cars;


public class CarsTest {
    @Test
    void 자동차_모두_전진_테스트() {
        List<String> carNames = List.of("pobi", "jun", "king");
        CarGameController carGameController = new CarGameController();
        Cars cars = new Cars(carGameController.createCars(carNames));

        assertThat(cars.moveAll().size()).isEqualTo(3);
    }
}
