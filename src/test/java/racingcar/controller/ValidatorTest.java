package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "d",
            "q",
            "0",
            "-1"
    })
    void 시도할_횟수_유효성_실패_테스트(String tryCount) {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateTryCount(tryCount));
    }

    @Test
    void 시도할_횟수_공백_확인() {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateTryCount(""));
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "10",
            "30"
    })
    void 시도할_횟수_유효성_성공_테스트(String tryCount) {
        assertDoesNotThrow(() -> Validator.validateTryCount(tryCount));
    }
}
