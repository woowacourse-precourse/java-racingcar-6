package study.serviceTest;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.TryNumberScanService;
import racingcar.service.TryNumberStringToIntService;

public class TryNumberScanServiceTest {

    @Test
    void readTryNumberTest() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        String example = "5";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        tryNumberScanService.readTryNumber();
        Assertions.assertThat(tryNumberScanService.getStringTryNumber()).isEqualTo("5");
    }

}
