package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceGameValidator {
    @Test
    void 시도_횟수가_최소_시도_횟수_이상인_경우() {
        int tryNum = 1;

        Assertions.assertDoesNotThrow(() -> InputValidator.tryNum(tryNum));
    }

    @Test
    void 시도_횟수가_최소_시도_횟수_이하인_경우_예외_발생() {
        int tryNum = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.tryNum(tryNum));
    }
}
