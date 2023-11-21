package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_BE_INTEGER;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_BE_MORE_THAN_ONE;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountValidationTest {
    private final TryCountValidation tryCountValidation;

    TryCountValidationTest() {
        tryCountValidation = new TryCountValidation();
    }

    @DisplayName("시도할 횟수가 빈 값인 경우 예외가 발생한다.")
    @Test
    void tryCountOccurErrorWhenIsEmpty() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountValidation.isNullOrEmpty(""));

        //then
        assertTrue(exception.getMessage().contains(TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("시도할 횟수가 null 값인 경우 예외가 발생한다.")
    @Test
    void tryCountOccurErrorWhenIsNull() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("시도할 횟수가 정수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc, 1q2w, 11zz, zz11"})
    void tryCountOccurErrorWhenIsNotInteger(String input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountValidation.isInteger(input));

        //then
        assertTrue(exception.getMessage().contains(TRY_COUNT_MUST_BE_INTEGER.message));
    }


    @DisplayName("시도할 횟수가 정수가 1이상의 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void tryCountOccurErrorWhenLowerThanOne(int input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountValidation.isMoreThanOne(input));

        //then
        assertTrue(exception.getMessage().contains(TRY_COUNT_MUST_BE_MORE_THAN_ONE.message));
    }
}