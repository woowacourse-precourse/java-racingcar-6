package util;

import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    void 음수_입력() {
        Validator validator = new Validator();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validRangeNumber(-1));
    }

    @Test
    void 맥스값_입력() {
        Validator validator = new Validator();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validParseInt("12345678910"));
    }

    @Test
    void 영어_입력() {
        Validator validator = new Validator();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validParseInt("asbw"));
    }

    @Test
    void 특수문자_입력() {
        Validator validator = new Validator();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validParseInt("*"));
    }
}
