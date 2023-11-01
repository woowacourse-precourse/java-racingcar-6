package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.validator.Validator.*;

class ValidatorTest {

    @Test
    void 빈값_입력_예외() {
        assertThrows(IllegalArgumentException.class, () -> validateName(" "));
    }

    @Test
    void 다섯_글자_초과_입력_예외() {
        assertThrows(IllegalArgumentException.class, () -> validateName("123456"));
    }

    @Test
    void 반복_횟수_문자_입력_예외() {
        assertThrows(IllegalArgumentException.class, () -> validatePosition("xxx"));
    }
}