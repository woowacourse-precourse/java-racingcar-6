package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class RaceServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 랜덤_번호_가져오기() {
        assertRandomNumberInRangeTest(
                () -> {
                    int movingNumber = Randoms.pickNumberInRange(0,9);
                    int stopNumber = Randoms.pickNumberInRange(0,9);
                    assertThat(movingNumber).isEqualTo(4);
                    assertThat(stopNumber).isEqualTo(3);
                },
                MOVING_FORWARD, STOP
        );
    }
}
