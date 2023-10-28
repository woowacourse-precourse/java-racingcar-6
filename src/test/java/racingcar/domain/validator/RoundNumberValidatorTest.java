package racingcar.domain.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수행할 라운드 수 검증 테스트")
class RoundNumberValidatorTest {

    @DisplayName("유효한 라운드 횟수는 검증 통과")
    @Test
    void testValidRoundNumber() {
        RoundNumberValidator validator = new RoundNumberValidator();
        assertDoesNotThrow(() -> validator.validate("5"));
    }

    @DisplayName("유효하지 않은 라운드 횟수 입력 시 오류 발생")
    @Test
    void testInvalidRoundNumberNonNumeric() {
        RoundNumberValidator validator = new RoundNumberValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
    }
}