package domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    Round round;

    @Test
    void 실행_횟수가_시도_횟수_미만인_경우() {
        int maxRound = 3;
        round = new Round(maxRound);

        for (int i = 0; i < maxRound; i++) {
            assertFalse(round.isMaxRound());
        }
    }

    @Test
    void 실행_횟수가_시도_횟수와_동일한_경우() {
        int maxRound = 3;
        round = new Round(maxRound);

        for (int i = 0; i <= maxRound; i++) {
            round.isMaxRound();
            if (i == maxRound) {
                assertTrue(round.isMaxRound());
            }
        }
    }
}