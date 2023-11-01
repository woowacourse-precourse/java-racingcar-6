package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest extends NsTest {


    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자_두명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_3개이상인_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,soni", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "soni : -", "최종 우승자 : soni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}