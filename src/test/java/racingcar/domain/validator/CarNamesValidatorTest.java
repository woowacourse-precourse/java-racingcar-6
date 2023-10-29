package racingcar.domain.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 검증 테스트")
class CarNamesValidatorTest {

    @DisplayName("유효한 자동차 이름은 검증을 통과한다")
    @Test
    void testValidCarNames() {
        List<String> carNames = Arrays.asList("pobi", "jun", "test");
        CarNamesValidator validator = new CarNamesValidator();
        assertDoesNotThrow(() -> validator.validate(carNames));
    }

    @DisplayName("길이가 0인 이름이 들어 있을 경우 오류가 발생한다")
    @Test
    void testInvalidCarNameLengthZero() {
        List<String> carNames = Arrays.asList("", "jun", "test");
        CarNamesValidator validator = new CarNamesValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate(carNames));
    }

    @DisplayName("최대 길이 초과하는 이름이 들어 있을 경우 오류가 발생한다")
    @Test
    void testInvalidCarNameLengthExceedingMax() {
        List<String> carNames = Arrays.asList("pobi12345", "jun", "test");
        CarNamesValidator validator = new CarNamesValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate(carNames));
    }
}