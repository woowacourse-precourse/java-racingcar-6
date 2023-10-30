package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;


class RacingCarGameControllerTest {

    RacingCarGameController racingCarGameController = new RacingCarGameController();

    @Test
    void 한줄로_입력_받은_자동차_이름_리스트_구분_기능() {
        List<String> carNameList = racingCarGameController.convertStringToCarList("벤츠,제네시스,소나타");
        assertThat(carNameList).contains("벤츠", "제네시스", "소나타");
    }


}