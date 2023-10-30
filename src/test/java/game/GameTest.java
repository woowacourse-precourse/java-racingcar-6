package game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.GameController;
import racingcar.view.GameView;

public class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 최종_우승자가_한_명_일때() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jay", "2");
                assertThat(output()).contains("pobi : ", "woni : ", "jay : -", "pobi : -",
                    "woni : -", "jay : --", "최종 우승자 : jay");
            },
            STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 최종_우승자가_두_명_일때() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jay", "2");
                assertThat(output()).contains("pobi : -", "woni : ", "jay : -", "pobi : --",
                    "woni : -", "jay : --", "최종 우승자 : pobi, jay");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}