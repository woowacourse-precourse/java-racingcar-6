package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacerTest extends NsTest {
    private static final String RACER_NAME = "ZZ3n";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 경주_전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("ZZ3n : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 경주_정지_테스트() {
        // output() 에서 trim 하기 때문에 뒤의 공백 삭제하였습니다.
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("ZZ3n :");
                },
                STOP
        );
    }

    @Override
    protected void runMain() {
        Racer racer = new Racer(RACER_NAME);
        racer.proceedTurn();
    }
}