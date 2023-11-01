package racingcar.view;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_기준_수_확인() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "3");
                    assertThat(output()).contains("a : ---", "b : -", "최종 우승자 : a");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 단독_우승_확인() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "3");
                    assertThat(output()).contains("a : --", "b : -", "최종 우승자 : a");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 중복_우승_확인() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "3");
                    assertThat(output()).contains("a : --", "b : --", "최종 우승자 : a,b");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}