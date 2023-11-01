package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void moveForwardTest() {
        // 전진 결과를 테스트한다.
        assertRandomNumberInRangeTest(
                () -> {
                    run("lee,kim", "2");
                    assertThat(output()).contains("lee : -", "kim : ", "lee : --", "kim : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void getWinnersTest() {
        // 최종 우승자를 테스트한다.
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,cde,ert", "2");
                    assertThat(output()).contains("최종 우승자 : cde,ert");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}