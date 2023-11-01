package model;

import static model.ErrorMessage.INVALID_RANGE;
import static model.ErrorMessage.INVALID_TYPE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TryCountTest {

    private static final int MIN_TRY_COUNT = 1;
    private static final int LESS_THAN_MIN = MIN_TRY_COUNT - 1;

    @Test
    void 입력이_숫자가_아닌_경우_예외처리() {
        // given
        String nonDigitValue = "nonDigit";

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                TryCount.from(nonDigitValue);
            });
            assertEquals(INVALID_TYPE.getMessage(), exception.getMessage());
        });
    }

    @Test
    void 입력_숫자가_최소_횟수_미만일_경우_예외처리() {
        // given
        String inputValue = String.valueOf(LESS_THAN_MIN);

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                TryCount.from(inputValue);
            });
            assertEquals(INVALID_RANGE.getMessage(), exception.getMessage());
        });

    }

    @Test
    void 시도_횟수가_1일_때_한_번_시도하면_더_이상_사용할_수_없음() {
        // given
        TryCount count = TryCount.from("1");

        // when
        count.useOneCount();

        // then
        assertFalse(count.canUseCount());
    }
}
