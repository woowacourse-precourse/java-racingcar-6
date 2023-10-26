package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingCarControllerTest {
    RacingCarController racingCarController = new RacingCarController();
    @Test
    void 레이싱카_이름_입력() {
        String racingCar= "pobi,woni,jun";

        List<String> racingCarList= racingCarController.racingCarNameConvertStringToArray(racingCar);
        assertThat(racingCarList).contains("pobi", "woni", "jun");
    }
}