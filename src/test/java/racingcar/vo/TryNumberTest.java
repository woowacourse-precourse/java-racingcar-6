package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

    public static final Integer MIN_TRY_NUMBER = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MESSAGE = " 이상의 정수값만 입력할 수 있습니다.";

    @DisplayName("시도 횟수가 유효한 경우 객체를 생성할 수 있다.")
    @Test
    void validTryNumber_test() {
        // given
        Integer validNumber = MIN_TRY_NUMBER;

        // when
        TryNumber tryNumber = assertDoesNotThrow(() -> {
            return new TryNumber(validNumber);
        });

        // then
        assertEquals(validNumber, tryNumber.number());
    }

    @DisplayName("시도 횟수가 유효하지 않은 경우 객체가 생성되지 않고 예외가 발생한다.")
    @Test
    void invalidTryNumber_test() {
        Integer invalidNumber = MIN_TRY_NUMBER - 1;

        try {
            TryNumber tryNumber = new TryNumber(invalidNumber);
        } catch (IllegalArgumentException e) {
            assertEquals(MIN_TRY_NUMBER + SMALLER_THAN_MIN_NUMBER_MESSAGE, e.getMessage());
        }
    }
}
