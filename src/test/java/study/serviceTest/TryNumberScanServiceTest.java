package study.serviceTest;

import camp.nextstep.edu.missionutils.Console;
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
        Console.close();    // static 으로 정적 영역에 올라와 있는 Console.scanner 에 값이 있는 경우 null 로 바꾼다.
        tryNumberScanService.readTryNumber();
        Assertions.assertThat(tryNumberScanService.getStringTryNumber()).isEqualTo("5");

    }

}
