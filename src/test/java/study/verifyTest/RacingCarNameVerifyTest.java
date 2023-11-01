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
        Console.close();    // static 으로 정적 영역에 올라와 있는 Console.scanner 에 값이 있는 경우 null 로 바꾼다.
        racingCarNameScanService.readRacingCarNames();

        RacingCarNameVerify racingCarNameVerify = new RacingCarNameVerify(racingCarNameScanService);
        Assertions.assertThat(racingCarNameVerify.verify()).isEqualTo(true);


    }
}
