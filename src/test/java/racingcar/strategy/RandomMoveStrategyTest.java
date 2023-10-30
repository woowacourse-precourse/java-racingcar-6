package racingcar.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 움직임_판단_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
                    assertTrue(randomMoveStrategy.shouldMove());
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 움직이지_않음_판단_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
                    assertFalse(randomMoveStrategy.shouldMove());
                },
                STOP
        );
    }

}