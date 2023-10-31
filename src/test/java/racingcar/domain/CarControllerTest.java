package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarControllerTest {

    @Test
    void 이동횟수_감소() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.produceCars(carNameList);
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

    @Test
    void 우승자_한명() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.produceCars(carNameList);
        CarController carController = new CarController();
        carController.setStatus(cars, 1);

        assertRandomNumberInRangeTest(() -> {
                    //when
                    carController.moveCars();
                    //then
                    assertThat(carController.findWinner()).isEqualTo("pobi1");
                },
                4, 3, 3
        );
    }

    @Test
    void 우승자_여러명() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.produceCars(carNameList);
        CarController carController = new CarController();
        carController.setStatus(cars, 1);

        assertRandomNumberInRangeTest(() -> {
                    //when
                    carController.moveCars();
                    //then
                    assertThat(carController.findWinner()).isEqualTo("pobi1, pobi2, pobi3");
                },
                4, 4, 4
        );
    }
}
