package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 출력시_자동차_이름_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1", "1");
                    assertThat(output()).contains("car1 : ");
                },
                STOP
        );
    }

    @Test
    void 전진한만큼_다시_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "1");
                    assertThat(output()).contains("car1 : -", "car2 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 한명_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "3");
                    assertThat(output()).contains("최종 우승자 : car1");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 여러_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "3");
                    assertThat(output()).contains("최종 우승자 : car1, car2");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
