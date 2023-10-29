package study.serviceTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.TryNumberScanService;
import racingcar.service.TryNumberStringToIntService;

public class TryNumberStringToIntServiceTest {

    @Test
    void executeTest() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        TryNumberStringToIntService tryNumberStringToIntService = new TryNumberStringToIntService(tryNumberScanService);
        String example = "5";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        Console.close();
        tryNumberScanService.readTryNumber();
        tryNumberStringToIntService.execute();
        Assertions.assertThat(TryNumberStringToIntService.tryNumber).isEqualTo(5);
    }
}
