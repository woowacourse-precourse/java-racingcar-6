package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptValidatorTest {
    @Test
    public void 유효한_숫자값_입력() {
        String validNumber = "5";
        AttemptValidator.checkValidAttemptNumber(validNumber);
    }

    @Test
    public void 문자값_입력_에러발생() {
        String invalidNumber = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidator.checkValidAttemptNumber(invalidNumber);
        });
    }

    public void 공백_숫자값_입력_에러발생() {
        String invalidNumber = "12 34";
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidator.checkValidAttemptNumber(invalidNumber);
        });
    }

    public void 음수값_입력_에러발생() {
        String invalidNumber = "-12";
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidator.checkValidAttemptNumber(invalidNumber);
        });
    }
}