package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TryNumberTest {

    @Test
    void 입력_시도횟수_보다_경주안했을_때_확인() {
        TryNumber tryNumber = new TryNumber("3");
        assertTrue(tryNumber.isNotOver(1));
    }
}
