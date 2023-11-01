package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    @Test
    void 우승자_한명() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        Cars cars = new Cars();
        CarManager carManager = new CarManager();
        cars.setStatus(CarFactory.produceCars(carNameList));
        carManager.setStatus(cars, 1);

        assertRandomNumberInRangeTest(() -> {
                    //when
                    carManager.moveCars();
                    //then
                    assertThat(Referee.findWinner(cars)).isEqualTo("pobi1");
                },
                4, 3, 3
        );
    }

    @Test
    void 우승자_여러명() {
        //given
        List<String> carNameList = List.of("pobi1", "pobi2", "pobi3");
        Cars cars = new Cars();
        CarManager carManager = new CarManager();
        cars.setStatus(CarFactory.produceCars(carNameList));
        carManager.setStatus(cars, 1);

        assertRandomNumberInRangeTest(() -> {
                    //when
                    carManager.moveCars();
                    //then
                    assertThat(Referee.findWinner(cars)).isEqualTo("pobi1, pobi2, pobi3");
                },
                4, 4, 4
        );
    }
}
