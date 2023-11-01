package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.Configuration.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("게임 진행")
    void 게임_진행1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3,DY4", "5");
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : \r\nDY3 : -\r\nDY4 : ",
                            "DY1 : -\r\nDY2 : -\r\nDY3 : -\r\nDY4 : -",
                            "DY1 : --\r\nDY2 : -\r\nDY3 : --\r\nDY4 : -",
                            "DY1 : --\r\nDY2 : --\r\nDY3 : --\r\nDY4 : --",
                            "DY1 : ---\r\nDY2 : --\r\nDY3 : ---\r\nDY4 : --",
                            "최종 우승자 : DY1, DY3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("게임 진행")
    void 게임_진행2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3,DY4", "5");
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : \r\nDY3 : -\r\nDY4 : ",
                            "DY1 : --\r\nDY2 : \r\nDY3 : --\r\nDY4 : ",
                            "DY1 : ---\r\nDY2 : \r\nDY3 : ---\r\nDY4 : ",
                            "DY1 : ----\r\nDY2 : \r\nDY3 : ----\r\nDY4 : ",
                            "DY1 : -----\r\nDY2 : \r\nDY3 : -----\r\nDY4 : ",
                            "최종 우승자 : DY1, DY3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("게임 진행")
    void 게임_진행3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3,DY4", "5");
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : \r\nDY3 : -\r\nDY4 : ",
                            "DY1 : --\r\nDY2 : \r\nDY3 : -\r\nDY4 : ",
                            "DY1 : --\r\nDY2 : \r\nDY3 : --\r\nDY4 : ",
                            "DY1 : ---\r\nDY2 : -\r\nDY3 : ---\r\nDY4 : ",
                            "DY1 : ----\r\nDY2 : -\r\nDY3 : ---\r\nDY4 : -",
                            "최종 우승자 : DY1");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP, STOP,
                STOP, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Game game = game();
        game.play();
    }
}