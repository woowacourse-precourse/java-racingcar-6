package racingcar.Exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TryCountNumberExceptionTest {
    @Test
    void testValidateTryCountInput_ValidInput_올바른_입력() {
        TryCountNumberException tryCountNumberException = new TryCountNumberException();
        String tryCountNumInput = "5";

        assertDoesNotThrow(() -> tryCountNumberException.validateTryCountInput(tryCountNumInput));
    }

    @Test
    void testValidateTryCountInput_NoInput_입력값_없음() {
        TryCountNumberException tryCountNumberException = new TryCountNumberException();
        String tryCountNumInput = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountNumberException.validateTryCountInput(tryCountNumInput));
        assertThat(exception.getMessage()).isEqualTo("값을 입력해주세요.");
    }

    @Test
    void testValidateTryCountInput_NonNumericInput_char_숫자가_아닌_입력_문자() {
        TryCountNumberException tryCountNumberException = new TryCountNumberException();
        String tryCountNumInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountNumberException.validateTryCountInput(tryCountNumInput));
        assertThat(exception.getMessage()).isEqualTo("시도할 횟수는 숫자여야 합니다.");
    }

    @Test
    void testValidateTryCountInput_NonNumericInput_special_Symbol_숫자가_아닌_입력_특수문자() {
        TryCountNumberException tryCountNumberException = new TryCountNumberException();
        String tryCountNumInput = "!^&'";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountNumberException.validateTryCountInput(tryCountNumInput));
        assertThat(exception.getMessage()).isEqualTo("시도할 횟수는 숫자여야 합니다.");
    }

    @Test
    void testValidateTryCountInput_WhitespaceInput_공백_입력() {
        TryCountNumberException tryCountNumberException = new TryCountNumberException();
        String tryCountNumInput = " ";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tryCountNumberException.validateTryCountInput(tryCountNumInput));
        assertThat(exception.getMessage()).isEqualTo("시도할 횟수는 숫자여야 합니다.");
    }
}