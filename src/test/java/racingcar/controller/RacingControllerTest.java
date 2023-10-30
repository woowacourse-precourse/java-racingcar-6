package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;


public class RacingControllerTest {
    RacingController racingController = new RacingController();

    @Test
    void makeCarList_test() {
        // given
        List<String> carNameList = Arrays.asList("pobi", "woni", "jun");

        // when
        List<Car> carList = racingController.makeCarList(carNameList);

        // then
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(0).getDistance()).isEqualTo(0);
    }
}
