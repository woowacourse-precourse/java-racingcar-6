package study.verifyTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarNameScanService;
import racingcar.verify.RacingCarNameVerify;

public class RacingCarNameVerifyTest {

    @Test
    void verifyTest() {
        RacingCarNameScanService racingCarNameScanService = new RacingCarNameScanService();
        String example = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        Console.close();
        racingCarNameScanService.readRacingCarNames();

        RacingCarNameVerify racingCarNameVerify = new RacingCarNameVerify(racingCarNameScanService);
        Assertions.assertThat(racingCarNameVerify.verify()).isEqualTo(true);


    }
}
