package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameValidatorTest {

    Validator validator = new NameValidator();

    @ParameterizedTest
    @DisplayName("[통과해야하는 케이스] 이름 검증 테스트")
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void successTest(String input) {
        validator.validate(input);
    }

    @ParameterizedTest
    @DisplayName("[실패야하는 케이스] 이름 검증 테스트")
    @ValueSource(strings = {"", "ChunJiwoo"})
    void failTest(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }
}