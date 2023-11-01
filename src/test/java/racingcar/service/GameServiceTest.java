package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("선두가 한 명인 경우 단독으로 우승자를 출력한다.")
    void GameServiceTest1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jiyoo", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "jiyoo : ",
                            "pobi : --", "woni : -", "jiyoo : -",
                            "pobi : ---", "woni : --", "jiyoo : --",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("선두가 두 명인 경우 콤마로 구분하여 우승자를 출력한다.")
    void GameServiceTest2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jiyoo", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "jiyoo : ",
                            "pobi : --", "woni : --", "jiyoo : -",
                            "pobi : ---", "woni : ---", "jiyoo : --",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}