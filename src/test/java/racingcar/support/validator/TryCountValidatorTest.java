package racingcar.support.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.argument.LessThanTryCountMinException;

class TryCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 최솟값 이하인 경우 예외 발생")
    void validateMin() {
        // given
        Long tryCount = 0L;

        // when

        // then
        assertThrows(LessThanTryCountMinException.class,
            () -> TryCountValidator.validate(tryCount));
    }
}