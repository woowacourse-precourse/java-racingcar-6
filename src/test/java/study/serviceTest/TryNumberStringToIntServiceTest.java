package study.serviceTest;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.TryNumberScanService;
import racingcar.service.TryNumberStringToIntService;

public class TryNumberStringToIntServiceTest {

    @Test
    void stringToIntTest() {
        String example = "5";
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        TryNumberStringToIntService tryNumberStringToIntService = new TryNumberStringToIntService(tryNumberScanService);
        Assertions.assertThat(tryNumberStringToIntService.stringToInt(example)).isEqualTo(5);
    }

    @Test
    void executeTest() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        TryNumberStringToIntService tryNumberStringToIntService = new TryNumberStringToIntService(tryNumberScanService);
        String example = "5";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        tryNumberScanService.readTryNumber();
        tryNumberStringToIntService.execute();
        Assertions.assertThat(TryNumberStringToIntService.tryNumber).isEqualTo(5);
    }
}
