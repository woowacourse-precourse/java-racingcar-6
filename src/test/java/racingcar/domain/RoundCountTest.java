package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundCountTest {

    @DisplayName("유효한 라운드 횟수가 입력되면 검증을 통과한다")
    @Test
    void testValidRoundNumber() {
        assertDoesNotThrow(() -> new RoundCount("5"));
    }

    @DisplayName("숫자가 아닌 값이 입력 되면 오류가 발생한다")
    @Test
    void testInvalidRoundNumberNonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> new RoundCount("abc"));
    }

    @DisplayName("남은 라운드를 올바르게 체크할 수 있다")
    @Test
    void testConsumingRound() {
        RoundCount roundCount = new RoundCount("5");
        for (int i = 0; i < 5; i++) {
            assertTrue(roundCount.hasNextRound());
            roundCount.consumeRound();
        }
        assertFalse(roundCount.hasNextRound());
    }
}