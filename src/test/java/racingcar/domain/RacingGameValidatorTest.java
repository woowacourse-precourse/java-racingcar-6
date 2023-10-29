package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameValidatorTest {

    @Test
    @DisplayName("자동차이름들로 빈 문자열이 주어질 때 예외 발생")
    void carInputEmptyTest() {
        String name = "";
        RacingGameValidator.validateCarName(name);
    }
}