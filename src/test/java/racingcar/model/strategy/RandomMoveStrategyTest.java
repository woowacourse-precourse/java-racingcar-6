package racingcar.model.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomMoveStrategyTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 난수가_4_이상이면_전진_가능() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(moveStrategy.shouldMove()).isTrue();
                },
                MOVING_FORWARD
        );
    }


    @Test
    void 난수가_3_이하면_전진_불가능() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(moveStrategy.shouldMove()).isFalse();
                },
                STOP
        );
    }

}
