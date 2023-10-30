package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 검증 테스트")
class CarNameTest {

    @DisplayName("유효한 자동차 이름은 검증을 통과한다")
    @Test
    void testValidCarNames() {
        assertDoesNotThrow(() -> new CarName("pobi"));
    }

    @DisplayName("길이가 0인 이름은 오류가 발생한다")
    @Test
    void testInvalidCarNameLengthZero() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @DisplayName("길이 5를 초과하는 이름은 오류가 발생한다")
    @Test
    void testInvalidCarNameLengthExceedingMax() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("abcdefg"));
    }
}