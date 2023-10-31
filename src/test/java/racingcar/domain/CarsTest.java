package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차들_움직이기() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.produceCars(carNameList);

        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    cars.move();
                    //then
                    assertThat(cars.getCarList().get(0).getMoveStatus()).isEqualTo(1);
                    assertThat(cars.getCarList().get(1).getMoveStatus()).isEqualTo(0);
                    assertThat(cars.getCarList().get(2).getMoveStatus()).isEqualTo(1);
                },
                4, 3, 4
        );
    }
}
