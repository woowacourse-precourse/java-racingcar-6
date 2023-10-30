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

    @Test
    @DisplayName("이름 최소 크기 미달 테스트")
    void validationCarNameTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validationCarName("ABC,DEF,");
        });
    }

    @Test
    @DisplayName("숫자 이외의 값 입력 테스트")
    void validationTrialNumberTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validationTrialNumber("A");
        });
    }

    @Test
    @DisplayName("입력 없음 테스트")
    void validationTrialNumberTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validationTrialNumber("");
        });
    }
}