package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

    private static final Integer MIN_TRY_NUMBER = 1;

    @DisplayName("시도 횟수가 유효한 경우 레코드를 생성할 수 있다.")
    @Test
    void validTryNumber_test() {
        Integer validNumber = MIN_TRY_NUMBER;

        TryNumber tryNumber = assertDoesNotThrow(() -> {
            return new TryNumber(validNumber);
        });
        assertEquals(validNumber, tryNumber.number());
    }

    @DisplayName("시도 횟수가 1 이하의 정수인 경우 레코드가 생성되지 않고 예외가 발생한다.")
    @Test
    void invalidTryNumber_test() {
        Integer invalidNumber = MIN_TRY_NUMBER - 1;

        assertThrows(IllegalArgumentException.class, () -> new TryNumber(invalidNumber));
    }
}
