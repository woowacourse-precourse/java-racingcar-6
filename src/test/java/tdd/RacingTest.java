package tdd;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.RacingController;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 경주_자동차이름_반점_기준으로_구분() {
        RacingController car = new RacingController();
        String input = "pobi,woni,jun";
        String[] lst = car.generateRacersFromNames(input);

        assertThat(lst).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

}
