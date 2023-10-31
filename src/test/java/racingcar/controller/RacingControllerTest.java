package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RacingControllerTest {


    @Test
    void 레이스_진행시_우승자를_1명이상_반환() {
        RacingController racingController = new RacingController();
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        int numberOfExecution = 3;

        List<Car> winners = racingController.race(carNames, numberOfExecution);

        Assertions.assertThat(winners).isNotEmpty();
    }


}
