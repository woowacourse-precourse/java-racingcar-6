package racingcar.domain.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수행할 라운드 수 검증 테스트")
class RoundNumberValidatorTest {

    @DisplayName("유효한 라운드 횟수가 입력되면 검증을 통과한다")
    @Test
    void testValidRoundNumber() {
        RoundNumberValidator validator = new RoundNumberValidator();
        assertDoesNotThrow(() -> validator.validate("5"));
    }

    @DisplayName("숫자가 아닌 값이 입력 되면 오류가 발생한다")
    @Test
    void testInvalidRoundNumberNonNumeric() {
        RoundNumberValidator validator = new RoundNumberValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
    }
}