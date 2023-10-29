package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 한번시도_한명_전진(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 한번시도_한명_정지(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi :");
                },
                STOP
        );
    }

    @Test
    void 한번시도_한명_전진_한명_정지(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,wobi", "1");
                    assertThat(output()).contains("pobi : -", "wobi :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 두번시도(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,wobi", "2");
                    assertThat(output()).contains("pobi : --", "wobi : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void game1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
