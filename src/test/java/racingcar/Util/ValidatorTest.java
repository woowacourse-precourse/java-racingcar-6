package racingcar.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("이름 최대 크기 초과 테스트")
    void validationCarNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validationCarName("ABCDEF,abc");
        });
    }
}