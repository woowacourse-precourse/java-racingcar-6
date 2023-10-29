package study.verifyTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.TryNumberScanService;
import racingcar.verify.TryNumberVerify;

public class TryNumberVerifyTest {

    @Test
    void verifyTest() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();

        String example = "5";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        Console.close();
        tryNumberScanService.readTryNumber();

        TryNumberVerify tryNumberVerify = new TryNumberVerify(tryNumberScanService);
        Assertions.assertThat(tryNumberVerify.verify()).isEqualTo(true);

    }
}
