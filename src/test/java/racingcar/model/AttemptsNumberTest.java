package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.exception.RacingCarExceptionType.INVALID_TRY_COUNT_FORMAT;
import static racingcar.exception.RacingCarExceptionType.NON_POSITIVE_TRY_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptsNumberTest {

    @DisplayName("유효한 문자열로 AttemptsNumber 객체를 성공적으로 생성한다.")
    @Test
    void createValidAttemptsNumber() {
        // given
        String str = "5";

        // when
        AttemptsNumber attemptsNumber = new AttemptsNumber(str);

        // then
        assertThat(attemptsNumber.getAttemptsNumber()).isEqualTo(5);
    }

    @DisplayName("숫자가 아닌 문자열로 AttemptsNumber 객체 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionOnInvalidString() {
        // given
        String str = "test";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AttemptsNumber(str);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_TRY_COUNT_FORMAT.getMessage());
    }

    @DisplayName("0 또는 음수 문자열로 AttemptsNumber 객체 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionOnNonPositiveValue() {
        // given
        String str = "-5";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AttemptsNumber(str);
        });
        assertThat(exception.getMessage()).isEqualTo(NON_POSITIVE_TRY_COUNT.getMessage());
    }

}