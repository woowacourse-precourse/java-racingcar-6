package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 참가자_3명_모두_동점() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,toni", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "toni : -",
                            "pobi : --",
                            "woni : -",
                            "toni : -",
                            "pobi : --",
                            "woni : --",
                            "toni : --",
                            "최종 우승자 : pobi, toni, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 참가자_3명_2명_동점() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,toni", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "toni : -",
                            "pobi : -",
                            "woni : --",
                            "toni : -",
                            "pobi : -",
                            "woni : --",
                            "toni : --",
                            "최종 우승자 : toni, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 참가자_3명_1명_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,toni", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "toni : -",
                            "pobi : --",
                            "woni : -",
                            "toni : -",
                            "pobi : --",
                            "woni : -",
                            "toni : -",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
