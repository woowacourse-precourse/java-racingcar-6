package racingcarv2.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundTotalTest {
    @Test
    void 범위_벗어나지_않으면_성공() {
        Assertions.assertDoesNotThrow(
                () -> new RoundTotal(3)
        );
    }
}
