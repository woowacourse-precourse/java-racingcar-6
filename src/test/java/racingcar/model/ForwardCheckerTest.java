package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForwardCheckerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private ForwardChecker forwardChecker = new ForwardChecker();

    @Test
    void 전진_플래그() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertTrue(forwardChecker.isForward());
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 후진_플래그() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertFalse(forwardChecker.isForward());
                },
                STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }
}
