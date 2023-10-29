package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RacingControllerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingController racingController = new RacingController();

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "3");
            assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : -",
                    "pobi : --", "woni : --", "최종 우승자 : pobi,woni");
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }

    @Override
    public void runMain() {
        racingController.playGame();
    }
}
