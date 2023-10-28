package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TryCountTest {

    private static final int MIN_TRY_COUNT = 1;
    private static final int LESS_THAN_MIN = MIN_TRY_COUNT - 1;

    @Test
    void 입력이_숫자가_아닌_경우_예외처리() {
        // given
        String nonDigitValue = "nonDigit";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            TryCount.from(nonDigitValue);
        });
    }

    @Test
    void 입력_숫자가_최소_횟수_미만일_경우_예외처리() {
        // given
        String inputValue = String.valueOf(LESS_THAN_MIN);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            TryCount.from(inputValue);
        });
    }
}
