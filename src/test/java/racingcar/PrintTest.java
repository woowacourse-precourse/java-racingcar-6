package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class PrintTest extends ApplicationTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void testWinners() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD,MOVING_FORWARD
        );
    }

    @Test
    void testAtLeastOneWinner() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
            },
            STOP,STOP
        );
    }
}
