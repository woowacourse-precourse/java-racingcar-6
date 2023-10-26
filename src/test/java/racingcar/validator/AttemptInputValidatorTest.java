package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptInputValidatorTest {

    Validator validator = new AttemptsInputValidator();

    @ParameterizedTest
    @DisplayName("[통과해야하는 케이스]시도 회수 검증 테스트")
    @ValueSource(strings = {"1", "10", "100", "1000"})
    void successTest(String input) {
        validator.validate(input);
    }

    @ParameterizedTest
    @DisplayName("[실패야하는 케이스]시도 회수 검증 테스트")
    @ValueSource(strings = {"-1", "1b", ",a", "no"})
    void failTest(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }
}