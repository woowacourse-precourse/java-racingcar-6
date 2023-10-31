package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("숫자 검사 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10"})
    void testInputNumberValidator(String number) {
        assertDoesNotThrow(() -> validator.inputNumberValidator(number));
    }

    @DisplayName("숫자 검사 기능 exception 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobi", "하이", "1 "})
    void testInputNumberValidatorThrow(String number) {
        assertThrows(IllegalArgumentException.class, () -> validator.inputNumberValidator(number));
    }
}
