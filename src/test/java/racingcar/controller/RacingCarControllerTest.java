package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class RacingCarControllerTest {
    RacingCarController racingCarController = new RacingCarController();

    @Test
    void 레이싱카_입력_리스트_생성_테스트() {
        String racingCar = "pobi,woni,jun";
        String expectedName1 = "pobi";
        String expectedName2 = "woni";
        String expectedName3 = "jun";

        List<RacingCar> racingCarList = racingCarController.racingCarNameConvertStringToArray(racingCar);

        assertThat(racingCarList)
                .extracting("name")
                .contains(expectedName1, expectedName2, expectedName3);
    }

}