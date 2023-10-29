package tdd;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.RacingController;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 경주_참여자_레이서_입력(){
        RacingController racer = new RacingController();
        String input = "pobi,woni,jun";
        String[] lst = racer.generateRacersFromNames(input);

        assertThat(lst).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

}
