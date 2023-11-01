package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingRuleTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private MovingRule movingRule;
    private Car car;

    @BeforeEach
    void setUp() {
        movingRule = new MovingRule();
    }

    @Test
    void 전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    int randomNumber = numberGenerator.generate();
                    assertThat(movingRule.isMovable(randomNumber)).isEqualTo(true);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    int randomNumber = numberGenerator.generate();
                    assertThat(movingRule.isMovable(randomNumber)).isEqualTo(false);
                },
                STOP
        );
    }
}
