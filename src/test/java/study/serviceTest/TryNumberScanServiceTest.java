package study.serviceTest;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.TryNumberScanService;

public class TryNumberScanServiceTest {

    @Test
    void readTryNumberTest() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        String example = "5";
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        tryNumberScanService.readTryNumber();
        Assertions.assertThat(TryNumberScanService.tryNumber).isEqualTo(5);
    }

    @Test
    void stringToInt() {
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        int example = tryNumberScanService.stringToInt("5");
        Assertions.assertThat(example).isEqualTo(5);
    }
}
