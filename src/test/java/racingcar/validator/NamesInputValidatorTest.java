package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesInputValidatorTest {

    Validator validator = new NamesInputValidator();

    @ParameterizedTest
    @DisplayName("[통과해야하는 케이스] 이름 입력 검증 테스트")
    @ValueSource(strings = {"pobi,woni,jun", "jiwoo"})
    void successTest(String input) {
        validator.validate(input);
    }

    @ParameterizedTest
    @DisplayName("[실패야하는 케이스] 이름 입력 검증 테스트")
    @ValueSource(strings = {""})
    void failTest(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }
}