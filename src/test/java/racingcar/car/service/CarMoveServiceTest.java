package racingcar.car.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarMoveServiceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;

    private static final int STOP = 3;

    @Test
    void 랜덤_이동_결정() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "6");
            assertThat(output()).contains("pobi : -", "woni : ", "pobi : -", "woni : -", "pobi : --", "woni : -",
                    "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
