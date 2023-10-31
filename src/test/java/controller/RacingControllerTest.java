package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RacingControllerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    final RacingController racingController = new RacingController();

    @Test
    void 컨트롤러_게임_진행_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jiny", "2");
            assertThat(output()).contains("pobi : -", "woni : ", "jiny : -", "pobi : --", "woni : ",
                    "jiny : --", "최종 우승자 : pobi,jiny");
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }

    @Override
    public void runMain() {
        racingController.start();
    }
}
