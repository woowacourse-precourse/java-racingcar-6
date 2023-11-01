package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceGameValidatorTest {
    private final RaceGameValidator raceGameValidator = new RaceGameValidator();
    @Test
    void tryNum_시도_횟수가_최소_시도_횟수_이상인_경우() {
        int tryNum = 1;

        Assertions.assertDoesNotThrow(() -> raceGameValidator.tryNum(tryNum));
    }

    @Test
    void tryNum_시도_횟수가_최소_시도_횟수_이하인_경우_예외_발생() {
        int tryNum = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> raceGameValidator.tryNum(tryNum));
    }
}
