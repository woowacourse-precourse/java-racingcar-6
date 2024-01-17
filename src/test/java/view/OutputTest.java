package view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class OutputTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 2;

    @Test
    void 위치_정보_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : -");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_두명_정보_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,mgo", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_한명_정보_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,mgo", "1");
                    assertThat(output()).contains("최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() { Application.main(new String[]{}); }
}
