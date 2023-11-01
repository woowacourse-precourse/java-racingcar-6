package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.views.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_다수일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,defg,hij", "2");
                    assertThat(output()).contains("abc : --", "defg : --", "hij : ", "최종 우승자 : abc, defg");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 단독_우승일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,defg,hij", "2");
                    assertThat(output()).contains("abc : --", "defg : -", "hij : ", "최종 우승자 : abc");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
