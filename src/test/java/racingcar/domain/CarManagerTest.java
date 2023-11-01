package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarManagerTest {

    @Test
    void 이동횟수_0일시_false로_변하는지_확인() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        Cars cars = new Cars();
        CarManager carManager = new CarManager();
        cars.setStatus(CarFactory.produceCars(carNameList));
        carManager.setStatus(cars, 2);

        //when
        carManager.moveCars();
        //then
        assertThat(carManager.checkMoveChance()).isEqualTo(true);

        //when
        carManager.moveCars();
        //then
        assertThat(carManager.checkMoveChance()).isEqualTo(false);
    }
}
