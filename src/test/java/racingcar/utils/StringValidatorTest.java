package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringValidatorTest {
    @Test
    void 문자열_입력_NULL_예외처리() {
        assertTrue(StringValidator.isBlank(null));
    }

    @Test
    void 문자열_입력_공백_예외처리() {
        assertTrue(StringValidator.isBlank(""));
    }

    @Test
    void 문자열_입력_스페이스바_예외처리() {
        assertTrue(StringValidator.isBlank("         "));
    }

}