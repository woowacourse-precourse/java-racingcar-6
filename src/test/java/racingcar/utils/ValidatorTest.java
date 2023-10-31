package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ValidatorTest {
    Validator validator = new Validator();

    private static final String WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE = "이름은 5자 이하여야 합니다";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "이름이 중복되어선 안됩니다";

    @Test
    void 차_이름_길이_예외테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNameInput("wonjun,abc,def");
        });
        assertEquals(WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    void 차_이름_중복_예외테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNameInput("abc,abc,def");
        });
        assertEquals(CAR_NAME_DUPLICATION_ERROR_MESSAGE, e.getMessage());
    }
}