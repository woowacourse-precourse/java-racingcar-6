package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarControllerTest {

    @Test
    void 이동횟수_0일시_false로_변하는지_확인() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        Cars cars = CarFactory.produceCars(carNameList);
        CarController carController = new CarController();
        carController.setStatus(cars, 2);

        //when
        carController.moveCars();
        //then
        assertThat(carController.checkMoveChance()).isEqualTo(true);

        //when
        carController.moveCars();
        //then
        assertThat(carController.checkMoveChance()).isEqualTo(false);
    }
}
