package racingcar.carRacing.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarRacingGameServiceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;

    private static final int STOP = 3;

    @Test
    void 지정_회수만큼_게임_진행() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "3");
            assertThat(output()).contains("pobi : -", "woni : -", "pobi : -", "woni : -", "pobi : -", "woni : -",
                    "최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP, STOP);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
