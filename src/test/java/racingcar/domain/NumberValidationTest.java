package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberValidationTest {

    @Test
    void 오직_숫자만_입력된다() {
        String invalid = "0001";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new NumberValidation(invalid));
        assertEquals("ERROR: 잘못된 횟수 입력입니다", exception.getMessage());
    }
}