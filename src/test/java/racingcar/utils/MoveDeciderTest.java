package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveDeciderTest {
    @Test
    void 입력이_4_미만의_수일때_결과는_STOP() {
        // when
        MoveStatus moveStatus = MoveDecider.decideToMove(3);

        // then
        Assertions.assertEquals(MoveStatus.STOP, moveStatus);
    }

    @Test
    void 입력이_4_이상의_수일때_결과는_MOVE() {
        // when
        MoveStatus moveStatus = MoveDecider.decideToMove(7);

        // then
        Assertions.assertEquals(MoveStatus.MOVE, moveStatus);
    }
}
