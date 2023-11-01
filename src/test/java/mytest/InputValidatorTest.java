package mytest;

import org.junit.jupiter.api.Test;
import racingcar.InputValidator;

import static org.junit.jupiter.api.Assertions.*;
public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 라운드수_입력_검증_가능한_수() {
        assertDoesNotThrow(() -> validator.validateRoundNumber(5));
    }

    @Test
    void 라운드수_입력_검증_잘못된_수() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateRoundNumber(-1));
    }

    @Test
    void 자동차_이름입력_가능한_이름() {
        assertDoesNotThrow(() -> validator.validateCarNames("benz,bmw,kia"));
    }

    @Test
    void 자동차_이름_입력_5자리초과() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames("hyundai,bmw"));
    }

    @Test
    void 자동차_이름_입력_비어있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames(",bmw"));
    }
}
